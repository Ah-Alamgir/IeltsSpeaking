$ErrorActionPreference = 'Stop'
$edgePath = "C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"
$userDataDir = "C:\tmp\edge_test_console"
if (Test-Path $userDataDir) { Remove-Item -Recurse -Force $userDataDir }

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

    Start-Sleep -Seconds 3

    # Switch to Live Call tab
    $evalRes = Send-Cdp "Runtime.evaluate" @{
        expression = @'
JSON.stringify({
    peerInitialized: typeof peer !== "undefined" && !!peer,
    peerId: typeof myPeerId !== "undefined" ? myPeerId : null,
    mqttConnected: typeof mqttClient !== "undefined" && mqttClient ? mqttClient.connected : false,
    availablePeers: typeof availablePeers !== "undefined" ? Array.from(availablePeers.keys()) : []
})
'@
    }
    Write-Host "State: $($evalRes.result.result.value)"

    # Take screenshot of Edge
    $ss = Send-Cdp "Page.captureScreenshot" @{ format = "png" }
    $ssBytes = [System.Convert]::FromBase64String($ss.result.data)
    [System.IO.File]::WriteAllBytes("c:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\scratch\edge_render.png", $ssBytes)
    Write-Host "Screenshot saved to edge_render.png"

    $ws.CloseAsync([System.Net.WebSockets.WebSocketCloseStatus]::NormalClosure, "Done", $ct).Wait()
}
finally {
    if ($proc -and -not $proc.HasExited) {
        $proc.Kill()
    }
}
