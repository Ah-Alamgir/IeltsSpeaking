try {
    $content = Get-Content 'c:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_app.html' -Raw
    $xml = [xml]$content
    Write-Host "VALID XML!"
}
catch {
    Write-Host "XML Parse Error: " $_.Exception.Message
}
