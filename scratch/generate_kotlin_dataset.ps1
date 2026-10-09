# Generator script to create AuthenticCambridgeArchive.kt for Android (Clean ASCII)
$ErrorActionPreference = 'Stop'

$outFile = "C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\app\src\main\java\com\ielts\speaking\data\repository\AuthenticCambridgeArchive.kt"

# Read generate_cambridge_dataset.ps1 and extract lines 6 to 395
$lines = [System.IO.File]::ReadAllLines("C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\scratch\generate_cambridge_dataset.ps1", [System.Text.Encoding]::UTF8)
$dataBlock = ($lines[5..394]) -join "`n"

Invoke-Expression $dataBlock

Write-Host "Successfully loaded $($yearData.Length) years definition for Kotlin!"

$sb = New-Object System.Text.StringBuilder
[void]$sb.AppendLine("package com.ielts.speaking.data.repository")
[void]$sb.AppendLine()
[void]$sb.AppendLine("import com.ielts.speaking.data.model.Band9Vocabulary")
[void]$sb.AppendLine()
[void]$sb.AppendLine("object AuthenticCambridgeArchive {")
[void]$sb.AppendLine("    val themes: Map<Int, SpeakingDataProvider.YearTheme> = mapOf(")

function Clean-Kt([string]$s) {
    if ([string]::IsNullOrEmpty($s)) { return "" }
    $res = $s.Replace('"', '\"').Replace('$', '\$')
    # Replace any non-ascii or bullet with \u2022
    $res = $res -replace '[^\x20-\x7E]', '\u2022'
    return $res
}

for ($yi = 0; $yi -lt $yearData.Length; $yi++) {
    $y = $yearData[$yi]
    $yr = $y.year
    $bk = $y.book
    $sets = $y.sets
    
    [void]$sb.AppendLine("        $yr to SpeakingDataProvider.YearTheme(")
    [void]$sb.AppendLine("            year = $yr,")
    [void]$sb.AppendLine("            cambridgeBook = ""Cambridge IELTS $bk"",")

    for ($si = 0; $si -lt 4; $si++) {
        $sNum = $si + 1
        $s = $sets[$si]
        
        $cueTitle = Clean-Kt $s.p2
        if ($cueTitle.Length -gt 45) { $cueTitle = $cueTitle.Substring(0, 45) + "..." }
        $themeStr = Clean-Kt $s.title
        $p1Topic = Clean-Kt $s.p1
        $p2Cue = Clean-Kt $s.p2
        $p3Topic = Clean-Kt $s.p3
        $p4Topic = Clean-Kt $s.p4
        
        $setProp = "set$sNum"
        [void]$sb.AppendLine("            $setProp = SpeakingDataProvider.SetInfo(")
        [void]$sb.AppendLine("                title = ""$cueTitle"",")
        [void]$sb.AppendLine("                theme = ""$themeStr"",")
        [void]$sb.AppendLine("                p1Topic = ""$p1Topic"",")
        
        # p1 questions
        $p1qList = ($s.p1q | ForEach-Object { '"' + (Clean-Kt $_) + '"' }) -join ', '
        [void]$sb.AppendLine("                p1Questions = listOf($p1qList),")
        
        [void]$sb.AppendLine("                p2Cue = ""$p2Cue"",")
        $p2bList = ($s.p2b | ForEach-Object { '"' + (Clean-Kt $_) + '"' }) -join ', '
        [void]$sb.AppendLine("                p2Bullets = listOf($p2bList),")
        
        [void]$sb.AppendLine("                p3Topic = ""$p3Topic"",")
        $p3qList = ($s.p3q | ForEach-Object { '"' + (Clean-Kt $_) + '"' }) -join ', '
        [void]$sb.AppendLine("                p3Questions = listOf($p3qList),")
        
        [void]$sb.AppendLine("                p4Topic = ""$p4Topic"",")
        $p4qList = ($s.p4q | ForEach-Object { '"' + (Clean-Kt $_) + '"' }) -join ', '
        [void]$sb.AppendLine("                p4Questions = listOf($p4qList),")
        
        [void]$sb.AppendLine("                keyVocab = listOf(")
        [void]$sb.AppendLine("                    Band9Vocabulary(""Indispensable dimension"", ""C2 Collocation"", ""Crucial element"", ""Maintaining focus is an indispensable dimension of success.""),")
        [void]$sb.AppendLine("                    Band9Vocabulary(""Unwavering perseverance"", ""C2 Collocation"", ""Continuous grit"", ""Overcoming hurdles demands unwavering perseverance.""),")
        [void]$sb.AppendLine("                    Band9Vocabulary(""Macroscopic stability"", ""Formal Lexis"", ""Broad societal balance"", ""Sound regulation fosters macroscopic stability.""),")
        [void]$sb.AppendLine("                    Band9Vocabulary(""Far-reaching ramifications"", ""C2 Collocation"", ""Deep consequences"", ""Unchecked policies carry far-reaching ramifications."")")
        [void]$sb.AppendLine("                )")
        $comma = if ($si -lt 3) { "," } else { "" }
        [void]$sb.AppendLine("            )$comma")
    }
    
    $yComma = if ($yi -lt $yearData.Length - 1) { "," } else { "" }
    [void]$sb.AppendLine("        )$yComma")
}

[void]$sb.AppendLine("    )")
[void]$sb.AppendLine("}")

[System.IO.File]::WriteAllText($outFile, $sb.ToString(), [System.Text.Encoding]::UTF8)
Write-Host "Successfully generated AuthenticCambridgeArchive.kt with $($yearData.Length) years!"
