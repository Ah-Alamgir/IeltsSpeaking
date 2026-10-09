$ErrorActionPreference = 'Stop'

$adb = "C:\Users\abuha\AppData\Local\Android\Sdk\platform-tools\adb.exe"
$edgePath = "C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"
$userDataDir = "C:\tmp\edge_test_e2e"
if (Test-Path $userDataDir) { Remove-Item -Recurse -Force $userDataDir }

$artifactDir = "C:\Users\abuha\.gemini\antigravity\brain\fe0c185c-5c6f-43c0-96e9-f1c5ab89f64d"

Write-Host "1. Launching Android App on emulator-5554..."
& $adb shell am start -n com.ielts.speaking/.MainActivity
Start-Sleep -Seconds 3

# Tap Tab 3 (Audio Call) on 1080x2400 screen: x=540, y=2230
Write-Host "2. Navigating Android App to Live Call Tab..."
& $adb shell input tap 540 2230
Start-Sleep -Seconds 2

Write-Host "3. Launching Web App in Edge..."
$url = "file:///c:/Users/abuha/AndroidStudioProjects/IeltsSpeaking/blogspot_app.html"
$proc = Start-Process -FilePath $edgePath -ArgumentList @(
    "--remote-debugging-port=9222",
    "--headless=new",
    "--no-first-run",
    "--no-default-browser-check",
    "--use-fake-ui-for-media-stream",
    "--use-fake-device-for-media-stream",
    "--disable-features=Translate,OptimizationHints,MediaRouter",
    "--user-data-dir=$userDataDir",
    "--window-size=440,900",
    $url
) -PassThru

Start-Sleep -Seconds 3

try {
    $targets = Invoke-RestMethod -Uri "http://127.0.0.1:9222/json"
    $target = $targets | Where-Object { $_.url -like "*blogspot_app.html*" }
    if (-not $target) { $target = $targets[0] }
    $wsUrl = $target.webSocketDebuggerUrl

    $ws = [System.Net.WebSockets.ClientWebSocket]::new()
    $ct = [System.Threading.CancellationToken]::None
    $ws.ConnectAsync([uri]$wsUrl, $ct).Wait()

    function Send-Cdp($method, $params = @{}) {
        $id = [System.Threading.Interlocked]::Increment([ref]$script:msgId)
        $payload = @{ id = $id; method = $method; params = $params } | ConvertTo-Json -Depth 10 -Compress
        $bytes = [System.Text.Encoding]::UTF8.GetBytes($payload)
        $segment = [System.ArraySegment[byte]]::new($bytes)
        $ws.SendAsync($segment, [System.Net.WebSockets.WebSocketMessageType]::Text, $true, $ct).Wait()

        $ms = [System.IO.MemoryStream]::new()
        $buffer = [byte[]]::new(16384)
        do {
            $seg = [System.ArraySegment[byte]]::new($buffer)
            $res = $ws.ReceiveAsync($seg, $ct).Result
            $ms.Write($buffer, 0, $res.Count)
        } while (-not $res.EndOfMessage)

        $ms.Position = 0
        $reader = [System.IO.StreamReader]::new($ms, [System.Text.Encoding]::UTF8)
        $resJson = $reader.ReadToEnd()
        return $resJson | ConvertFrom-Json
    }

    $script:msgId = 0

    Start-Sleep -Seconds 2

    Write-Host "4. Switching Web to Live Call Tab..."
    $navRes = Send-Cdp "Runtime.evaluate" @{
        expression = @"
JSON.stringify((() => {
    switchTab('call');
    return {
        tab: 'call',
        isSearchingRandom: isSearchingRandom,
        myPeerId: getOrCreatePermanentId()
    };
})())
"@
    }
    Write-Host "Web Live Call Status: $($navRes.result.result.value)"

    Write-Host "5. Waiting for Android and Web to auto-connect..."
    $connected = $false
    for ($i = 1; $i -le 12; $i++) {
        Start-Sleep -Seconds 1
        $status = Send-Cdp "Runtime.evaluate" @{
            expression = @"
JSON.stringify({
    second: $i,
    activePartnerId: activePartnerId,
    activeMediaCall: !!activeMediaCall,
    heading: document.getElementById('call-status-heading') ? document.getElementById('call-status-heading').innerText : '',
    inProgressVisible: document.getElementById('call-in-progress-controls') ? document.getElementById('call-in-progress-controls').style.display : '',
    timer: document.getElementById('call-timer-display') ? document.getElementById('call-timer-display').innerText : ''
})
"@
        }
        $val = $status.result.result.value | ConvertFrom-Json
        Write-Host "Second $i : Partner=$($val.activePartnerId) Heading=$($val.heading) Timer=$($val.timer)"
        if ($val.activePartnerId -and $val.inProgressVisible -eq 'flex') {
            $connected = $true
            Write-Host "SUCCESS: Auto-connected! Partner ID: $($val.activePartnerId)"
            break
        }
    }

    if (-not $connected) {
        throw "Failed to auto-connect within 12 seconds."
    }

    # Take in-call screenshot of Web
    $ssWeb = Send-Cdp "Page.captureScreenshot" @{ format = "png" }
    $ssWebBytes = [System.Convert]::FromBase64String($ssWeb.result.data)
    [System.IO.File]::WriteAllBytes("$artifactDir\web_call_connected.png", $ssWebBytes)

    # Take in-call screenshot of Android
    & $adb exec-out screencap -p > "$artifactDir\android_call_connected.png"
    Write-Host "Screenshots captured of active live call!"

    # 6. Save partner on Web
    Write-Host "6. Saving partner on Web..."
    Send-Cdp "Runtime.evaluate" @{
        expression = "saveCurrentPartnerToContacts();"
    }

    # 7. Save partner on Android (tap 'Save Partner' button at x=770, y=850)
    Write-Host "7. Tapping Save Partner on Android..."
    & $adb shell input tap 770 850
    Start-Sleep -Seconds 1

    # 8. On Android, tap 'Send Message' button at x=300, y=850 to navigate directly to direct chat
    Write-Host "8. Tapping Send Message to navigate to Messages tab on Android..."
    & $adb shell input tap 300 850
    Start-Sleep -Seconds 2

    # Capture Android Messages view
    & $adb exec-out screencap -p > "$artifactDir\android_messages_view.png"

    # 9. On Web, navigate to Messages tab and open direct chat
    Write-Host "9. Navigating Web to Messages Tab..."
    Send-Cdp "Runtime.evaluate" @{
        expression = "navigateToPartnerChat();"
    }
    Start-Sleep -Seconds 2

    # Capture Web Messages view
    $ssWebChat = Send-Cdp "Page.captureScreenshot" @{ format = "png" }
    $ssWebChatBytes = [System.Convert]::FromBase64String($ssWebChat.result.data)
    [System.IO.File]::WriteAllBytes("$artifactDir\web_messages_view.png", $ssWebChatBytes)

    Write-Host "10. Sending direct message from Web to Android..."
    Send-Cdp "Runtime.evaluate" @{
        expression = @"
(() => {
    const input = document.getElementById('direct-msg-input');
    if (input) {
        input.value = "Hello from Web IELTS Partner!";
        sendDirectMsg();
        return true;
    }
    return false;
})()
"@
    }
    Start-Sleep -Seconds 2

    # Capture Android receiving message
    & $adb exec-out screencap -p > "$artifactDir\android_message_received.png"
    Write-Host "Verification completed successfully!"

    $ws.CloseAsync([System.Net.WebSockets.WebSocketCloseStatus]::NormalClosure, "Done", $ct).Wait()
}
finally {
    if ($proc -and -not $proc.HasExited) {
        $proc.Kill()
    }
}
