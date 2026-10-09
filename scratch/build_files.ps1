$ErrorActionPreference = 'Stop'

$lottieJson = [System.IO.File]::ReadAllText('C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\switchusercards.json')

$themeFile = 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_theme.xml'
$htmlFile = 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_app.html'

$sbXml = New-Object System.Text.StringBuilder
$sbHtml = New-Object System.Text.StringBuilder

# Read CSS from scratch/generate_theme.ps1
$cssContent = (Get-Content -Path 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\scratch\generate_theme.ps1' -Raw)
$cssStartIndex = $cssContent.IndexOf('/* -------------------------------------------------------------')
$cssEndIndex = $cssContent.LastIndexOf('@''')
$css = $cssContent.Substring($cssStartIndex, $cssEndIndex - $cssStartIndex)

# ----------------- XML HEAD -----------------
[void]$sbXml.AppendLine('<?xml version="1.0" encoding="UTF-8" ?>')
[void]$sbXml.AppendLine('<!DOCTYPE html>')
[void]$sbXml.AppendLine('<html b:css=''false'' b:responsive=''true'' xmlns=''http://www.w3.org/1999/xhtml'' xmlns:b=''http://www.google.com/2005/gml/b'' xmlns:data=''http://www.google.com/2005/gml/data'' xmlns:expr=''http://www.google.com/2005/gml/expr''>')
[void]$sbXml.AppendLine('<head>')
[void]$sbXml.AppendLine('    <meta charset=''utf-8''/>')
[void]$sbXml.AppendLine('    <meta content=''width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no'' name=''viewport''/>')
[void]$sbXml.AppendLine('    <meta content=''yes'' name=''apple-mobile-web-app-capable''/>')
[void]$sbXml.AppendLine('    <meta content=''black-translucent'' name=''apple-mobile-web-app-status-bar-style''/>')
[void]$sbXml.AppendLine('    <meta content=''IELTS Speaking &amp; Writing Prep Pro'' name=''apple-mobile-web-app-title''/>')
[void]$sbXml.AppendLine('    <title><data:blog.pageTitle/></title>')
[void]$sbXml.AppendLine('    <link href=''https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;600;700;800&amp;display=swap'' rel=''stylesheet''/>')
[void]$sbXml.AppendLine('    <link href=''https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css'' rel=''stylesheet''/>')
[void]$sbXml.AppendLine('    <script src=''https://unpkg.com/peerjs@1.5.4/dist/peerjs.min.js''></script>')
[void]$sbXml.AppendLine('    <script src=''https://cdnjs.cloudflare.com/ajax/libs/lottie-web/5.12.2/lottie.min.js''></script>')
[void]$sbXml.AppendLine('    <script src=''https://unpkg.com/mqtt@5.16.0/dist/mqtt.min.js''></script>')
[void]$sbXml.AppendLine('    <b:skin><![CDATA[')
[void]$sbXml.AppendLine($css)
[void]$sbXml.AppendLine('    ]]></b:skin>')
[void]$sbXml.AppendLine('</head>')
[void]$sbXml.AppendLine('<body>')
[void]$sbXml.AppendLine('    <!-- REQUIRED BLOGGER SECTION -->')
[void]$sbXml.AppendLine('    <div style=''display:none;''>')
[void]$sbXml.AppendLine('        <b:section id=''main-blogger-content'' showaddelement=''no''>')
[void]$sbXml.AppendLine('            <b:widget id=''Blog1'' locked=''true'' title=''Blog Posts'' type=''Blog''>')
[void]$sbXml.AppendLine('                <b:includable id=''main''>')
[void]$sbXml.AppendLine('                    <b:loop values=''data:posts'' var=''post''>')
[void]$sbXml.AppendLine('                        <div class=''post-body''><data:post.body/></div>')
[void]$sbXml.AppendLine('                    </b:loop>')
[void]$sbXml.AppendLine('                </b:includable>')
[void]$sbXml.AppendLine('            </b:widget>')
[void]$sbXml.AppendLine('        </b:section>')
[void]$sbXml.AppendLine('    </div>')

# ----------------- HTML5 HEAD -----------------
[void]$sbHtml.AppendLine('<!DOCTYPE html>')
[void]$sbHtml.AppendLine('<html lang="en">')
[void]$sbHtml.AppendLine('<head>')
[void]$sbHtml.AppendLine('    <meta charset="utf-8"/>')
[void]$sbHtml.AppendLine('    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport"/>')
[void]$sbHtml.AppendLine('    <meta content="yes" name="apple-mobile-web-app-capable"/>')
[void]$sbHtml.AppendLine('    <meta content="black-translucent" name="apple-mobile-web-app-status-bar-style"/>')
[void]$sbHtml.AppendLine('    <title>IELTS Speaking &amp; Writing Prep Pro (Cambridge Official Edition)</title>')
[void]$sbHtml.AppendLine('    <link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;600;700;800&amp;display=swap" rel="stylesheet"/>')
[void]$sbHtml.AppendLine('    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet"/>')
[void]$sbHtml.AppendLine('    <script src="https://unpkg.com/peerjs@1.5.4/dist/peerjs.min.js"></script>')
[void]$sbHtml.AppendLine('    <script src="https://cdnjs.cloudflare.com/ajax/libs/lottie-web/5.12.2/lottie.min.js"></script>')
[void]$sbHtml.AppendLine('    <script src="https://unpkg.com/mqtt@5.16.0/dist/mqtt.min.js"></script>')
[void]$sbHtml.AppendLine('    <style>')
[void]$sbHtml.AppendLine($css)
[void]$sbHtml.AppendLine('    </style>')
[void]$sbHtml.AppendLine('</head>')
[void]$sbHtml.AppendLine('<body>')

Write-Host "Heads generated. Continuing to Body..."
