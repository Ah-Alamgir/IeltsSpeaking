$content = Get-Content 'c:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_app.html' -Raw

# Replace top html tag
$content = $content -replace '<!DOCTYPE html>\s*<html lang="en">', @"
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html b:css='false' b:defaultwidgetversion='2' b:layoutsversion='3' b:responsive='true' lang='en' xmlns='http://www.w3.org/1999/xhtml' xmlns:b='http://www.google.com/2005/gml/b' xmlns:data='http://www.google.com/2005/gml/data' xmlns:expr='http://www.google.com/2005/gml/expr'>
"@

# Replace <style> with <b:skin><![CDATA[ ... ]]></b:skin><style>/*<![CDATA[*/ ... /*]]>*/</style>
$content = $content -replace '<style>', "<b:skin><![CDATA[`n/* Blogspot Skin */`n]]></b:skin>`n<style>`n/*<![CDATA[*/"
$content = $content -replace '</style>', "/*]]>*/`n</style>"

# Replace <script> with <script type='text/javascript'>//<![CDATA[ ... //]]></script>
$content = $content -replace '<script>', "<script type='text/javascript'>`n//<![CDATA["
$content = $content -replace '</script>\s*</body>', "//]]>`n</script>`n<div style='display:none !important;'><b:section id='main' showaddelement='no'/></div>`n</body>"

# Test parse with [xml]
try {
    $xml = [xml]$content
    Write-Host "SUCCESS: Content is 100% VALID XML for Blogger!"
    [System.IO.File]::WriteAllText('c:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\scratch\test_transformed.xml', $content, [System.Text.Encoding]::UTF8)
}
catch {
    Write-Host "XML Error: " $_.Exception.Message
}
