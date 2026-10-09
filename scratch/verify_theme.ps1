$html = [System.IO.File]::ReadAllText("C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_app.html")

$speakingCardMatches = [regex]::Matches($html, 'openSpeakingYear\((\d{4})\)')
Write-Host "Total Speaking Cards in HTML: $($speakingCardMatches.Count)"

$years = @()
foreach ($m in $speakingCardMatches) {
    $years += [int]$m.Groups[1].Value
}
Write-Host "Years range: $(($years | Measure-Object -Minimum).Minimum) down to $(($years | Measure-Object -Maximum).Maximum)"

$images = [regex]::Matches($html, 'https://images.unsplash.com/[^\s''"&]+') | ForEach-Object { $_.Value } | Select-Object -Unique
Write-Host "Unique Unsplash images across HTML: $($images.Count)"

$speakingTopics = [regex]::Matches($html, '<h3 class=''card-topic-title''>([^<]+)</h3>') | ForEach-Object { $_.Groups[1].Value } | Select-Object -Unique
Write-Host "Unique Card Topics across HTML: $($speakingTopics.Count)"

# Test Cambridge archive JS definition
$archiveMatches = [regex]::Matches($html, '(?m)^\s*(\d{4}):\s*\{\s*year:\s*\1')
Write-Host "Unique Years defined in cambridgeSpeakingArchive: $($archiveMatches.Count)"

if ($speakingCardMatches.Count -eq 26 -and $images.Count -ge 26 -and $archiveMatches.Count -eq 26) {
    Write-Host "ALL WEB CHECKS PASSED PERFECTLY!" -ForegroundColor Green
} else {
    Write-Host "CHECKS FAILED!" -ForegroundColor Red
}
