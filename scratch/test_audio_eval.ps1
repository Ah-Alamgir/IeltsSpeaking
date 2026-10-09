$ErrorActionPreference = 'Stop'
$edgePath = "C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"
$userDataDir = "C:\tmp\edge_test_audio"
if (Test-Path $userDataDir) { Remove-Item -Recurse -Force $userDataDir }

$proc = Start-Process -FilePath $edgePath -ArgumentList @(
    "--remote-debugging-port=9223",
    "--headless=new",
    "--no-first-run",
    "--no-default-browser-check",
    "--use-fake-ui-for-media-stream",
    "--use-fake-device-for-media-stream",
    "--user-data-dir=$userDataDir",
    "file:///c:/Users/abuha/AndroidStudioProjects/IeltsSpeaking/blogspot_app.html"
) -PassThru

Start-Sleep -Seconds 2

try {
    $targets = Invoke-RestMethod -Uri "http://127.0.0.1:9223/json"
    $wsUrl = $targets[0].webSocketDebuggerUrl
    $ws = [System.Net.WebSockets.ClientWebSocket]::new()
    $ct = [System.Threading.CancellationToken]::None
    $ws.ConnectAsync([uri]$wsUrl, $ct).Wait()

    function Send-Cdp($method, $params = @{}) {
        $script:msgId++
        $payload = @{ id = $script:msgId; method = $method; params = $params } | ConvertTo-Json -Depth 10 -Compress
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
        return $reader.ReadToEnd() | ConvertFrom-Json
    }
    $script:msgId = 0

    $jsTest = @"
    (async () => {
        const stream = await navigator.mediaDevices.getUserMedia({
            audio: {
                echoCancellation: true,
                noiseSuppression: true,
                autoGainControl: false
            },
            video: false
        });
        const track = stream.getAudioTracks()[0];
        return JSON.stringify(track.getSettings());
    })()
"@

    $res = Send-Cdp "Runtime.evaluate" @{ expression = $jsTest; awaitPromise = $true; returnByValue = $true }
    Write-Host "Audio constraints result: $($res | ConvertTo-Json -Depth 6)"

} finally {
    if ($proc -and -not $proc.HasExited) {
        Stop-Process -Id $proc.Id -Force
    }
}
