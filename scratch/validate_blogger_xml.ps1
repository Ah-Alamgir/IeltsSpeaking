$lines = Get-Content 'c:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_app.html'
Write-Host "Total lines: $($lines.Count)"

$unclosedTags = @()
$invalidAmpersands = @()

for ($i = 0; $i -lt $lines.Count; $i++) {
    $lineNum = $i + 1
    # Check outside style (18..1037) and script (2287..8571)
    if (($lineNum -lt 18 -or $lineNum -gt 1037) -and ($lineNum -lt 2287 -or $lineNum -gt 8571)) {
        $l = $lines[$i]
        if ($l -match '&(?!(amp|lt|gt|quot|apos|#\d+|#x[0-9a-fA-F]+);)') {
            $invalidAmpersands += "Line ${lineNum}: $l"
        }
    }
}

Write-Host "Invalid ampersands found: $($invalidAmpersands.Count)"
$invalidAmpersands | Select-Object -First 20 | ForEach-Object { Write-Host $_ }
