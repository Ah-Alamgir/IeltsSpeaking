# ==============================================================================
# CLEAN MODERN SCHOLASTIC THEME & HTML APP BUILDER
# Strictly conforming to stitch_ielts_audio_prep_hub & DESIGN.md
# ==============================================================================
$ErrorActionPreference = 'Stop'

$projectDir = "C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking"
$themeFile = Join-Path $projectDir "blogspot_theme.xml"
$htmlFile = Join-Path $projectDir "blogspot_app.html"
$lottieFile = Join-Path $projectDir "switchusercards.json"
$cambridgeDataFile = Join-Path $projectDir "scratch\cambridge_data.js"
$stylesFile = Join-Path $projectDir "scratch\theme_styles.css"
$bodyFile = Join-Path $projectDir "scratch\theme_body.html"

Write-Host "Reading base components..."
$css = [System.IO.File]::ReadAllText($stylesFile, [System.Text.Encoding]::UTF8)
$bodyHtmlTemplate = [System.IO.File]::ReadAllText($bodyFile, [System.Text.Encoding]::UTF8)
$cambridgeJs = [System.IO.File]::ReadAllText($cambridgeDataFile, [System.Text.Encoding]::UTF8)
$lottieJson = [System.IO.File]::ReadAllText($lottieFile, [System.Text.Encoding]::UTF8)

# -------------------------------------------------------------
# GENERATE PRE-RENDERED STAGGERED CARDS (2026 down to 2001)
# Matching home_speaking_cambridge_archive_staggered
# -------------------------------------------------------------
$heights = @(175, 135, 160, 185, 145, 165)
$speakingImages = @(
    'https://images.unsplash.com/photo-1618005182384-a83a8bd57fbe?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1592478411213-6153e4ebc07d?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1466611653911-95081537e5b7?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1522202176988-66273c2fd55f?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1586528116311-ad8dd3c8310d?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1563986768609-322da13575f3?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1552832230-c0197dd311b5?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1526374965328-7f61d4dc18c5?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1523240795612-9a054b0db644?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1519389950473-47ba0277781c?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1452860606245-08befc0ff44b?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1477959858617-67f30bc75b82?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1500937386664-56d1dfef3854?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1461896836934-ffe607ba8211?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1521587760476-6c12a4b040da?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1507679799987-c73779587ccf?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1474487548417-781cb71495f3?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1565008447742-97f6f38c985c?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1470071459604-3b5ec3a7fe05?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1550751827-4bd374c3f58b?w=400&amp;auto=format&amp;fit=crop&amp;q=75'
)
$writingImages = @(
    'https://images.unsplash.com/photo-1551288049-bebda4e38f71?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1518770660439-4636190af475?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1488190211105-8b0e65b80b4e?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1509391365360-2e959784a276?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1522071820081-009f0129c71c?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1542601906990-b4d3fb778b09?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1446776811953-b23d57bd21aa?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1508962914676-134849a727f0?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1503899036084-c55cdd92da26?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1563089145-599997674d42?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1434030216411-0b793f4b4173?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1531482615713-2afd69097998?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1585829365295-ab7cd400c167?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1459411552884-841db9b3cc2a?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1444723121867-7a241cacace9?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1625246333195-78d9c38ad449?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1517649763962-0c623266ddc0?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1456513080510-7bf3a84b82f8?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1555421689-491a97ff2040?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1515162816999-a0c47dc192f7?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1582555172866-f73bb12a2ab3?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1448375240586-882707db888b?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1559027615-cd4628902d4a?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1455390582262-044cdead277a?w=400&amp;auto=format&amp;fit=crop&amp;q=75'
)

$topics = @(
    "Artificial Intelligence &amp; Future Work",
    "Sustainable Architecture &amp; Smart Cities",
    "Virtual Reality &amp; Immersive Learning",
    "Renewable Energy &amp; Climate Solutions",
    "Remote Collaboration &amp; Digital Nomads",
    "Global Supply Chains &amp; E-Commerce",
    "Public Health &amp; Urban Wellbeing",
    "Space Exploration &amp; Satellite Tech",
    "Electric Mobility &amp; Green Transport",
    "Cultural Heritage &amp; Modern Tourism",
    "Biodiversity &amp; Ocean Conservation",
    "Digital Privacy &amp; Cyber Security",
    "Lifelong Education &amp; Online Academics",
    "Youth Entrepreneurship &amp; Innovation",
    "Mass Media &amp; Investigative Journalism",
    "Traditional Arts &amp; Globalized Crafts",
    "Urbanization &amp; Megacities Infrastructure",
    "Alternative Agriculture &amp; Food Security",
    "International Sports &amp; Olympic Diplomacy",
    "Linguistic Diversity &amp; Endangered Tongues",
    "Consumer Psychology &amp; Advertising",
    "Transportation Networks &amp; High-Speed Rail",
    "Museums, Galleries &amp; Public History",
    "Wilderness Protection &amp; Eco-Tourism",
    "Intergenerational Community &amp; Volunteering",
    "Emerging Internet &amp; Global Communication"
)

$writingTopics = @(
    "AI Automation &amp; Global Labor Dynamics",
    "Zero-Carbon Urban Infrastructure",
    "Immersive Technologies in Primary Education",
    "Transition to Renewable Wind &amp; Solar Power",
    "Decentralized Remote Work Economics",
    "E-Commerce Footprint &amp; Supply Chain Logistics",
    "State Investment in Preventive Healthcare",
    "Commercial Space Mining &amp; Space Law",
    "Subsidizing Electric Vehicles vs Public Transit",
    "Mass Tourism Impact on Historic Monuments",
    "Marine Plastic Waste &amp; International Treaties",
    "Surveillance Technology vs Personal Privacy",
    "Standardized Testing in Modern Academics",
    "Fostering Innovation in SME Enterprises",
    "The Rise of Citizen Journalism &amp; Social Media",
    "Subsidizing Folk Crafts in Modern Economies",
    "High-Density Urban Living vs Suburban Sprawl",
    "Genetically Modified Crops &amp; Global Hunger",
    "Hosting Mega-Events: Financial Boon or Burden?",
    "Preserving Minority Languages in School Curricula",
    "Regulation of Aggressive Advertising to Children",
    "High-Speed Rail Networks vs Domestic Aviation",
    "Free Public Admission to National Museums",
    "Eco-Tourism: Commercial Exploitation vs Preservation",
    "Mandatory Civic Volunteering for High Schoolers",
    "The Advent of the Internet &amp; Information Democratization"
)

$parts = @("Part 2 Cue Card", "Part 1 &amp; 3", "Part 2 Cue Card", "Part 3 Discussion", "Part 1 Interview", "Part 2 Cue Card")
$bands = @("Band 7.5+", "Band 8.0", "Band 8.5", "Band 7.0+", "Band 8.0", "Band 7.5")

$sbSpeaking = New-Object System.Text.StringBuilder
$sbWriting = New-Object System.Text.StringBuilder

for ($i = 0; $i -lt 26; $i++) {
    $yr = 2026 - $i
    $h = $heights[$i % $heights.Length]
    $spImg = $speakingImages[$i]
    $wrImg = $writingImages[$i]
    $topic = $topics[$i]
    $wrTopic = $writingTopics[$i]
    $part = $parts[$i % $parts.Length]
    $band = $bands[$i % $bands.Length]

    $book = 20
    if ($yr -ge 2025) { $book = 20 }
    elseif ($yr -ge 2024) { $book = 19 }
    elseif ($yr -ge 2023) { $book = 18 }
    elseif ($yr -ge 2022) { $book = 17 }
    elseif ($yr -ge 2021) { $book = 16 }
    elseif ($yr -ge 2020) { $book = 15 }
    elseif ($yr -ge 2019) { $book = 14 }
    elseif ($yr -ge 2018) { $book = 13 }
    elseif ($yr -ge 2017) { $book = 12 }
    elseif ($yr -ge 2016) { $book = 11 }
    elseif ($yr -ge 2015) { $book = 10 }
    elseif ($yr -ge 2013) { $book = 9 }
    elseif ($yr -ge 2011) { $book = 8 }
    elseif ($yr -ge 2009) { $book = 7 }
    elseif ($yr -ge 2007) { $book = 6 }
    elseif ($yr -ge 2005) { $book = 5 }
    elseif ($yr -ge 2003) { $book = 4 }
    elseif ($yr -ge 2002) { $book = 3 }
    else { $book = 2 }

    [void]$sbSpeaking.AppendLine("                <article class='staggered-card' onclick='openSpeakingYear($yr)'>")
    [void]$sbSpeaking.AppendLine("                    <div class='staggered-media-box' style='height:${h}px;'>")
    [void]$sbSpeaking.AppendLine("                        <img src='$spImg' alt='IELTS $yr' class='staggered-img' loading='lazy' decoding='async'/>")
    [void]$sbSpeaking.AppendLine("                        <span class='staggered-part-tag'>$part</span>")
    [void]$sbSpeaking.AppendLine("                        <button class='quick-practice-btn' aria-label='Practice Speaking'><span class='material-symbols-outlined text-[18px]' style='font-variation-settings: ""FILL"" 1;'>mic</span></button>")
    [void]$sbSpeaking.AppendLine("                    </div>")
    [void]$sbSpeaking.AppendLine("                    <div class='staggered-card-body'>")
    [void]$sbSpeaking.AppendLine("                        <div class='card-meta-top'><span class='band-benchmark-pill'>$band</span></div>")
    [void]$sbSpeaking.AppendLine("                        <h3 class='card-topic-title'>$topic</h3>")
    [void]$sbSpeaking.AppendLine("                        <div class='card-meta-bottom'><span class='cambridge-vol-badge'>Cam $book</span><span>Year $yr</span></div>")
    [void]$sbSpeaking.AppendLine("                    </div>")
    [void]$sbSpeaking.AppendLine("                </article>")

    [void]$sbWriting.AppendLine("                <article class='staggered-card' onclick='openWritingYear($yr)'>")
    [void]$sbWriting.AppendLine("                    <div class='staggered-media-box' style='height:${h}px;'>")
    [void]$sbWriting.AppendLine("                        <img src='$wrImg' alt='Writing $yr' class='staggered-img' loading='lazy' decoding='async'/>")
    [void]$sbWriting.AppendLine("                        <span class='staggered-part-tag' style='background:rgba(0,108,73,0.88);'>Task Model</span>")
    [void]$sbWriting.AppendLine("                        <button class='quick-practice-btn' aria-label='Practice Writing'><span class='material-symbols-outlined text-[18px]' style='font-variation-settings: ""FILL"" 1;'>edit</span></button>")
    [void]$sbWriting.AppendLine("                    </div>")
    [void]$sbWriting.AppendLine("                    <div class='staggered-card-body'>")
    [void]$sbWriting.AppendLine("                        <div class='card-meta-top'><span class='band-benchmark-pill' style='color:var(--primary);'>Band 9.0 Solution</span></div>")
    [void]$sbWriting.AppendLine("                        <h3 class='card-topic-title'>$wrTopic</h3>")
    [void]$sbWriting.AppendLine("                        <div class='card-meta-bottom'><span class='cambridge-vol-badge'>Cam $book</span><span>Year $yr</span></div>")
    [void]$sbWriting.AppendLine("                    </div>")
    [void]$sbWriting.AppendLine("                </article>")
}

$speakingCards = $sbSpeaking.ToString()
$writingCards = $sbWriting.ToString()

# Insert pre-rendered cards into HTML Body
$bodyHtml = $bodyHtmlTemplate.Replace('<!-- SPEAKING_CARDS -->', $speakingCards).Replace('<!-- WRITING_CARDS -->', $writingCards)

# -------------------------------------------------------------
# APPLICATION JAVASCRIPT LOGIC (DEFINED EXACTLY ONCE)
# -------------------------------------------------------------
$appJsLogic = @'

    /* -------------------------------------------------------------
       EMBEDDED LOTTIE ANIMATION DATA
    ------------------------------------------------------------- */
    const switchUserCardsData = @@LOTTIE_JSON@@;

    /* -------------------------------------------------------------
       CORE APPLICATION STATE
    ------------------------------------------------------------- */
    let userProfile = {
        name: "Jhan Student",
        age: "23",
        country: "Vietnam",
        gender: "Male",
        targetBand: "Band 7.5"
    };

    let activeSpeakingYear = 2026;
    let activeSpeakingSetIndex = 0;
    let activeWritingYear = 2026;
    let activeWritingSetIndex = 0;

    /* -------------------------------------------------------------
       PERMANENT CANDIDATE ID MANAGEMENT
    ------------------------------------------------------------- */
    function getOrCreatePermanentId() {
        let id = localStorage.getItem('ielts_permanent_id');
        if (!id) {
            id = 'ielts-' + Math.random().toString(36).substring(2, 8).toUpperCase();
            localStorage.setItem('ielts_permanent_id', id);
        }
        return id;
    }

    function updateIdDisplays() {
        const id = getOrCreatePermanentId();
        const elPeer = document.getElementById('my-peer-id-text');
        if (elPeer) elPeer.innerText = id;
        const elChat = document.getElementById('chat-my-permanent-id');
        if (elChat) elChat.innerText = id;
        const elProf = document.getElementById('prof-permanent-id-text');
        if (elProf) elProf.innerText = id;
    }

    function copyPermanentId() {
        const id = getOrCreatePermanentId();
        copyTextToClipboard(id);
    }

    function sharePermanentId() {
        const id = getOrCreatePermanentId();
        if (navigator.share) {
            navigator.share({
                title: 'IELTS Speaking Audio Practice',
                text: `Join my live IELTS Speaking call using my Permanent Candidate ID: ${id}`,
                url: window.location.href
            }).catch(() => {});
        } else {
            copyPermanentId();
        }
    }

    function toggleEditCustomId() {
        const b = document.getElementById('edit-custom-id-box');
        b.style.display = b.style.display === 'none' ? 'block' : 'none';
        if (b.style.display === 'block') {
            document.getElementById('custom-id-input').value = getOrCreatePermanentId();
        }
    }

    function saveCustomPermanentId() {
        const input = document.getElementById('custom-id-input').value.trim();
        if (!input) return showToast("Please enter a valid ID");
        const clean = input.toLowerCase().replace(/\s+/g, '-');
        localStorage.setItem('ielts_permanent_id', clean);
        updateIdDisplays();
        document.getElementById('edit-custom-id-box').style.display = 'none';
        showToast("Candidate ID updated! Reconnecting WebRTC...");
        if (peerInstance) peerInstance.destroy();
        initWebRtcEngine();
    }

    /* -------------------------------------------------------------
       INSTANT NAVIGATION: SWITCH TABS (SCENES)
    ------------------------------------------------------------- */
    function showTopLoader() {
        const l = document.getElementById('top-page-loader');
        if (l) l.classList.add('active');
    }
    function hideTopLoader() {
        const l = document.getElementById('top-page-loader');
        if (l) l.classList.remove('active');
    }

    function switchTab(tabId) {
        hideTopLoader();

        // Hide all scenes
        const tabs = document.querySelectorAll('.tab-content');
        tabs.forEach(el => el.style.display = 'none');

        // Remove active from all nav items
        const navs = document.querySelectorAll('.nav-item');
        navs.forEach(el => el.classList.remove('active'));

        // Show target scene
        const targetTab = document.getElementById('tab-' + tabId);
        if (targetTab) {
            targetTab.style.display = 'block';
        }

        // Highlight target nav item
        const navBtn = document.getElementById('nav-' + tabId);
        if (navBtn) {
            navBtn.classList.add('active');
        }

        // Instant scroll to top
        window.scrollTo(0, 0);

        // Update header subtitle
        const subtitles = {
            'speaking': 'Speaking Archive',
            'writing': 'Writing Tasks',
            'call': 'Live Peer Match',
            'chat': 'Direct Messages',
            'profile': 'Candidate Profile'
        };
        const st = document.getElementById('header-subtitle');
        if (st) st.innerText = subtitles[tabId] || 'Cambridge Official';

        // Scene specific actions
        if (tabId === 'call') {
            initLottieCallAnimation();
        } else {
            if (isSearchingRandom && !activeMediaCall) {
                stopRandomMatchmaking();
            }
        }

        if (tabId === 'chat') {
            renderDirectContacts();
        }

        if (tabId === 'profile') {
            updateIdDisplays();
            loadUserProfile();
        }
    }

    /* -------------------------------------------------------------
       FILTER CONTROLS
    ------------------------------------------------------------- */
    function filterSpeakingGrid(filterYear, btn) {
        if (btn) {
            btn.parentElement.querySelectorAll('.filter-pill').forEach(b => b.classList.remove('active'));
            btn.classList.add('active');
        }
        const cards = document.querySelectorAll('#speaking-staggered-container .staggered-card');
        cards.forEach(c => {
            if (filterYear === 'all') {
                c.style.display = 'flex';
            } else {
                const text = c.innerText;
                c.style.display = text.includes(filterYear) ? 'flex' : 'none';
            }
        });
    }

    function filterSpeakingParts(part, btn) {
        if (btn) {
            btn.parentElement.querySelectorAll('.filter-pill').forEach(b => b.classList.remove('active'));
            btn.classList.add('active');
        }
        const cards = document.querySelectorAll('#speaking-staggered-container .staggered-card');
        cards.forEach(c => {
            if (part === 'all') {
                c.style.display = 'flex';
            } else {
                const text = c.innerText.toLowerCase();
                if (part === 'part1') c.style.display = text.includes('part 1') ? 'flex' : 'none';
                else if (part === 'part2') c.style.display = text.includes('part 2') ? 'flex' : 'none';
                else if (part === 'part3') c.style.display = text.includes('part 3') ? 'flex' : 'none';
            }
        });
    }

    /* -------------------------------------------------------------
       TAB 1: SPEAKING DETAIL VIEW (Cambridge Question Sets)
    ------------------------------------------------------------- */
    function openSpeakingYear(year) {
        showTopLoader();
        activeSpeakingYear = year;
        activeSpeakingSetIndex = 0;
        document.getElementById('speaking-grid-view').style.display = 'none';
        document.getElementById('speaking-detail-view').classList.add('active');
        const bookNum = getCambridgeBook(year);
        document.getElementById('speaking-detail-header').innerText = `Cambridge Book ${bookNum} \u2022 Year ${year}`;
        document.getElementById('speaking-back-title').innerText = `Cambridge ${year} Speaking Archive`;
        renderSpeakingSets();
        window.scrollTo(0, 0);
        setTimeout(hideTopLoader, 150);
    }

    function closeSpeakingDetail() {
        document.getElementById('speaking-detail-view').classList.remove('active');
        document.getElementById('speaking-grid-view').style.display = 'block';
        window.scrollTo(0, 0);
    }

    function renderSpeakingSets() {
        const paper = getSpeakingPaperData(activeSpeakingYear);
        const pillsContainer = document.getElementById('speaking-set-pills');
        pillsContainer.innerHTML = paper.sets.map((s, idx) => `
            <button class="module-set-pill ${idx === activeSpeakingSetIndex ? 'active' : ''}" onclick="selectSpeakingSet(${idx})">${s.setTitle}</button>
        `).join('');

        const currentSet = paper.sets[activeSpeakingSetIndex];
        const container = document.getElementById('speaking-questions-container');
        document.getElementById('speaking-topic-headline').innerText = currentSet.topicTheme;
        document.getElementById('speaking-active-set-indicator').innerText = `Active: Set ${activeSpeakingSetIndex + 1}`;

        container.innerHTML = currentSet.questions.map(q => {
            const isPart2 = q.partLabel.includes('Part 2');
            return `
                <div class="academic-card">
                    ${isPart2 ? `
                        <div class="academic-cue-band">
                            <div style="display:flex; align-items:center; gap:6px;">
                                <span class="material-symbols-outlined text-[18px]" style="color:var(--primary);">assignment</span>
                                <span style="font-size:11px; font-weight:800; text-transform:uppercase; color:var(--primary); letter-spacing:0.5px;">Candidate Task Card</span>
                            </div>
                            <span style="font-size:11px; font-weight:600; color:var(--on-surface-variant);">Prep: 1 min | Talk: 2 min</span>
                        </div>
                    ` : ''}

                    <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:8px;">
                        <span class="cambridge-vol-badge" style="background:var(--primary); color:white;">${q.partLabel}</span>
                        <span style="font-size:11px; font-weight:700; color:var(--secondary);">${q.qLabel}</span>
                    </div>

                    <h3 style="font-size:14px; font-weight:800; color:var(--primary); margin-bottom:6px;">${q.topicTitle || q.title || ''}</h3>
                    <div style="font-size:13px; color:var(--on-surface); line-height:1.5; margin-bottom:10px;">${q.prompt.replace(/\n/g, '<br/>')}</div>

                    ${q.bullets && q.bullets.length ? `
                        <div style="background:var(--surface-container-low); padding:10px 14px; border-radius:10px; margin-bottom:10px;">
                            <p style="font-size:12px; font-weight:700; color:var(--primary); margin-bottom:4px;">You should say:</p>
                            <ul style="padding-left:18px; font-size:12px; color:var(--on-surface); line-height:1.5;">
                                ${q.bullets.map(b => `<li>${b}</li>`).join('')}
                            </ul>
                        </div>
                    ` : ''}

                    <!-- Band 9.0 Model Answer Box -->
                    <div class="band-model-box">
                        <div style="display:flex; justify-content:space-between; align-items:center;">
                            <span style="font-size:11px; font-weight:800; background:#E8F8F2; color:#0EB57D; padding:2px 8px; border-radius:9999px;">
                                Band 9.0 Model Solution
                            </span>
                            <button class="filter-pill" onclick="copyTextToClipboard('${escapeJs(q.masterAnswer)}')">
                                <span class="material-symbols-outlined text-[14px]">content_copy</span> Copy
                            </button>
                        </div>

                        <div class="band-tabs-row">
                            ${[9.0, 8.5, 8.0, 7.5, 7.0, 6.5, 6.0, 5.5, 5.0].map((b, i) => `
                                <button class="band-tab-btn ${i === 0 ? 'active' : ''}" onclick="updateBandText(this, '${escapeJs(q.masterAnswer)}', ${b})">Band ${b.toFixed(1)}</button>
                            `).join('')}
                        </div>

                        <div class="answer-display-box" style="font-size:13px; color:var(--on-surface); line-height:1.6; margin-top:8px;">
                            ${highlightKeywords(q.masterAnswer)}
                        </div>
                    </div>
                </div>
            `;
        }).join('');
    }

    function selectSpeakingSet(idx) {
        activeSpeakingSetIndex = idx;
        renderSpeakingSets();
    }

    function highlightKeywords(text) {
        if (!text) return "";
        let out = escapeHtml(text);

        const band9Terms = [
            "anchor in maintaining mental focus",
            "mitigation of environmental degradation",
            "automated, contactless metro network",
            "statutory right to disconnect",
            "Looking toward the forthcoming decades",
            "deep sense of psychological calm",
            "streamlined, purposeful habits",
            "succumbing to erratic distractions",
            "proactive waste minimization",
            "encroach upon private sanctuaries",
            "Without a shadow of a doubt",
            "From an analytical standpoint",
            "In our increasingly digitized era",
            "binding legislative mandates",
            "binding legislative mandate",
            "in the face of adversity",
            "restore emotional composure",
            "preserve psychological equilibrium",
            "chronic occupational burnout",
            "indispensable legal safeguard",
            "unwavering perseverance",
            "psychological fortitude",
            "indispensable dimension",
            "structured methodologies",
            "profoundly multifaceted",
            "proactive civic education",
            "far-reaching ramifications",
            "To be completely candid",
            "To set the chronological scene",
            "ecological stewardship",
            "planetary stewardship",
            "substantive dividends",
            "revitalize cognitive vitality",
            "indispensable countermeasure",
            "cornerstone of my mobility",
            "multifaceted urban planning",
            "dedicated cycling boulevards",
            "intellectual acumen",
            "unconventional perspective",
            "instructional stepping stone",
            "augment human cognition",
            "exponential upward trajectory",
            "transcend complacency",
            "pervasive workplace anxiety",
            "interdisciplinary cooperation",
            "work-life equilibrium",
            "restorative downtime",
            "monumental milestone",
            "macroscopic stability",
            "regulatory frameworks",
            "grassroots endeavors",
            "paramount necessity",
            "equitable distribution",
            "inadvertently marginalize",
            "statutory mandates",
            "systemic dilemmas",
            "collective prosperity",
            "defining milestone",
            "formidable hurdle",
            "analytical maturity",
            "transformative impact",
            "essential respite",
            "sensory overload",
            "sedentary stagnation",
            "domestic composting",
            "grassroots activism",
            "corporate accountability",
            "consumer frugality",
            "unilaterally counterbalance",
            "industrial pollution",
            "industrial emissions",
            "fiscal deterrents",
            "synergistic fusion",
            "regulatory governance",
            "transit friction",
            "congestion pricing",
            "combustion vehicles",
            "pedestrian livability",
            "traditional bottlenecks",
            "urban livability",
            "alleviate congestion",
            "housing equity",
            "cognitive fatigue",
            "concerted effort",
            "analog pursuits",
            "indispensable boundary",
            "mental chatter",
            "disciplined detachment",
            "renewed clarity",
            "chronic burnout",
            "pervasive erosion",
            "temporal boundaries",
            "mental longevity",
            "curated facade",
            "divergent thinking",
            "profound inertia",
            "prestigious accolade",
            "conscientious effort",
            "intrinsic motivation",
            "paradigm shift",
            "automate mundane tasks",
            "strategic judgment",
            "precipitous decline",
            "unbridled rivalry",
            "social cohesion",
            "mental faculties",
            "academic pursuits",
            "Without hesitation",
            "When evaluating",
            "It becomes self-evident",
            "In my daily life",
            "From my perspective",
            "Looking ahead",
            "On the flip side",
            "First and foremost",
            "In conclusion",
            "In hindsight",
            "Consequently",
            "Conversely",
            "Ultimately",
            "meritocracy",
            "monolithic",
            "subordinated",
            "indispensable",
            "perseverance",
            "resilience",
            "stamina",
            "multifaceted",
            "equilibrium",
            "alleviate",
            "mitigate",
            "substantive",
            "stewardship",
            "livability",
            "dismantled"
        ];

        band9Terms.sort((a, b) => b.length - a.length);
        const escaped = band9Terms.map(t => t.replace(/[.*+?^${}()|[\]\\]/g, '\\$&'));
        const regex = new RegExp(`\\b(${escaped.join('|')})\\b`, 'gi');
        return out.replace(regex, '<mark class="lexical-highlight">$1</mark>');
    }

    /* -------------------------------------------------------------
       TAB 2: WRITING DETAIL VIEW
    ------------------------------------------------------------- */
    function openWritingYear(year) {
        showTopLoader();
        activeWritingYear = year;
        activeWritingSetIndex = 0;
        document.getElementById('writing-grid-view').style.display = 'none';
        document.getElementById('writing-detail-view').classList.add('active');
        const bookNum = getCambridgeBook(year);
        document.getElementById('writing-detail-header').innerText = `Cambridge Book ${bookNum} \u2022 Year ${year}`;
        renderWritingSets();
        window.scrollTo(0, 0);
        setTimeout(hideTopLoader, 150);
    }

    function closeWritingDetail() {
        document.getElementById('writing-detail-view').classList.remove('active');
        document.getElementById('writing-grid-view').style.display = 'block';
        window.scrollTo(0, 0);
    }

    function renderWritingSets() {
        const paper = getWritingPaperData(activeWritingYear);
        const pillsContainer = document.getElementById('writing-set-pills');
        pillsContainer.innerHTML = paper.sets.map((s, idx) => `
            <button class="module-set-pill ${idx === activeWritingSetIndex ? 'active' : ''}" onclick="selectWritingSet(${idx})">${s.setTitle}</button>
        `).join('');

        const currentSet = paper.sets[activeWritingSetIndex];
        const container = document.getElementById('writing-questions-container');
        document.getElementById('writing-topic-headline').innerText = currentSet.topicTheme;

        container.innerHTML = currentSet.questions.map(q => `
            <div class="academic-card">
                <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:8px;">
                    <span class="cambridge-vol-badge" style="background:var(--secondary); color:white;">${q.taskTypeLabel}</span>
                    <span style="font-size:11px; font-weight:700; color:var(--primary);">${q.qLabel}</span>
                </div>
                <h3 style="font-size:14px; font-weight:800; color:var(--primary); margin-bottom:6px;">${q.topicTitle}</h3>
                <div style="font-size:13px; color:var(--on-surface); line-height:1.5; margin-bottom:10px;">${q.prompt.replace(/\n/g, '<br/>')}</div>

                <div class="band-model-box">
                    <div style="display:flex; justify-content:space-between; align-items:center;">
                        <span style="font-size:11px; font-weight:800; background:#E8F8F2; color:#0EB57D; padding:2px 8px; border-radius:9999px;">
                            Band 9.0 Solution
                        </span>
                        <button class="filter-pill" onclick="copyTextToClipboard('${escapeJs(q.masterAnswer)}')">
                            <span class="material-symbols-outlined text-[14px]">content_copy</span> Copy
                        </button>
                    </div>

                    <div class="band-tabs-row">
                        ${[9.0, 8.5, 8.0, 7.5, 7.0, 6.5, 6.0, 5.5, 5.0].map((b, i) => `
                            <button class="band-tab-btn ${i === 0 ? 'active' : ''}" onclick="updateBandText(this, '${escapeJs(q.masterAnswer)}', ${b})">Band ${b.toFixed(1)}</button>
                        `).join('')}
                    </div>

                    <div class="answer-display-box" style="font-size:13px; color:var(--on-surface); line-height:1.6; margin-top:8px;">
                        ${highlightKeywords(q.masterAnswer)}
                    </div>
                </div>
            </div>
        `).join('');
    }

    function selectWritingSet(idx) {
        activeWritingSetIndex = idx;
        renderWritingSets();
    }

    function onSandboxInput() {
        const text = document.getElementById('essay-sandbox').value.trim();
        const words = text ? text.split(/\s+/).length : 0;
        document.getElementById('writing-word-count').innerText = `${words} words ${words >= 250 ? '✓ (Task 2 Min Met)' : (words >= 150 ? '✓ (Task 1 Min Met)' : '')}`;
    }

    function updateBandText(btnEl, masterAns, band) {
        const parent = btnEl.closest('.band-model-box');
        parent.querySelectorAll('.band-tab-btn').forEach(b => b.classList.remove('active'));
        btnEl.classList.add('active');

        const displayBox = parent.querySelector('.answer-display-box');
        if (band >= 8.5) {
            displayBox.innerHTML = highlightKeywords(masterAns);
        } else if (band >= 7.5) {
            displayBox.innerText = "I would like to share my perspective on this topic. Over the past couple of years, this has been an essential area of personal development. When facing this situation, I implemented structured approaches to resolve the core issues effectively. The outcome was highly favorable and provided valuable life lessons.";
        } else if (band >= 6.5) {
            displayBox.innerText = "I want to talk about this topic because it is important for me. A couple of years ago, I had a big challenge with my schedule. It was hard because I had many exams at the same time. But I made a study timetable and asked my friends for help. Finally I passed all my exams with good grades, so I was very happy.";
        } else {
            displayBox.innerText = "This happened to me some time ago. It was very difficult and I felt stressed. But my teacher helped me and I tried my best every day. So in the end everything was okay and I learned many good things.";
        }
    }

    /* -------------------------------------------------------------
       TAB 3: LOTTIE ANIMATION & RANDOM MATCHMAKER
    ------------------------------------------------------------- */
    let lottieAnimInstance = null;
    function initLottieCallAnimation() {
        // Animation handled by authentic Sonar/Radar rings in Stitch design
    }

    let mqttClient = null;
    let isSearchingRandom = false;
    let searchInterval = null;
    let activeCallChatTopic = null;
    let processedCallMsgIds = new Set();
    const MATCH_LOBBY_TOPIC = "ielts/speaking/match_lobby_v1";

    function subscribeCallSessionTopic(partnerId) {
        if (!mqttClient || !partnerId) return;
        const myId = getOrCreatePermanentId();
        activeCallChatTopic = "ielts/call_chat/" + [myId, partnerId].sort().join('_');
        try {
            mqttClient.subscribe(activeCallChatTopic);
        } catch(e) {}
    }

    function unsubscribeCallSessionTopic() {
        if (activeCallChatTopic && mqttClient) {
            try {
                mqttClient.unsubscribe(activeCallChatTopic);
            } catch(e) {}
            activeCallChatTopic = null;
        }
    }

    function initMqttMatchmaking() {
        try {
            if (typeof mqtt === 'undefined') {
                setTimeout(initMqttMatchmaking, 300);
                return;
            }
            mqttClient = mqtt.connect("wss://broker.hivemq.com:8884/mqtt", {
                clientId: 'ielts_web_' + Math.random().toString(16).substring(2, 8),
                clean: true,
                keepalive: 30
            });

            mqttClient.on('connect', () => {
                const myId = getOrCreatePermanentId();
                mqttClient.subscribe(MATCH_LOBBY_TOPIC);
                mqttClient.subscribe('ielts/dm/' + myId);
            });

            mqttClient.on('message', (topic, payload) => {
                const myId = getOrCreatePermanentId();

                // 1. IN-CALL LIVE CHAT
                if (activeCallChatTopic && topic === activeCallChatTopic) {
                    try {
                        const data = JSON.parse(payload.toString());
                        if (data.senderId === myId) return;
                        if (data.msgId && processedCallMsgIds.has(data.msgId)) return;
                        if (data.msgId) processedCallMsgIds.add(data.msgId);

                        appendChatMessageToFeed(data.senderName || "Partner", data.text, data.time, false);

                        const sheet = document.getElementById('incall-chat-sheet');
                        if (!sheet.classList.contains('open')) {
                            incallUnreadCount++;
                            const badge = document.getElementById('call-unread-badge');
                            if (badge) badge.style.display = 'block';
                            showToast(`${data.senderName || "Partner"}: ${data.text.substring(0, 25)}...`);
                        }
                    } catch(e) {}
                    return;
                }

                // 2. MATCHMAKING CANDIDATE DISCOVERY
                if (topic === MATCH_LOBBY_TOPIC && isSearchingRandom && !activeMediaCall) {
                    try {
                        const msg = JSON.parse(payload.toString());
                        if (msg.type === 'WAITING' && msg.peerId && msg.peerId !== myId) {
                            const now = Date.now();
                            if (now - msg.timestamp < 12000) {
                                if (myId < msg.peerId) {
                                    stopRandomMatchmaking();
                                    startOutgoingCallTo(msg.peerId, msg.name, msg.targetBand, msg.country);
                                }
                            }
                        }
                    } catch (e) {}
                    return;
                }

                // 3. TAB 4 DIRECT 1-ON-1 CHAT
                if (topic === ('ielts/dm/' + myId)) {
                    try {
                        const data = JSON.parse(payload.toString());
                        const senderId = data.senderId;
                        const senderName = data.senderName || ("Partner (" + senderId.slice(-4) + ")");

                        let contacts = getSavedContacts();
                        let contact = contacts.find(c => c.id === senderId);
                        if (!contact) {
                            contact = {
                                id: senderId,
                                name: senderName,
                                country: data.senderCountry || "Global",
                                targetBand: data.senderBand || "Band 7.5",
                                lastMsg: data.text,
                                lastTime: data.time
                            };
                            contacts.unshift(contact);
                        } else {
                            contact.lastMsg = data.text;
                            contact.lastTime = data.time;
                        }
                        saveContactsList(contacts);

                        saveChatMessage(senderId, {
                            sender: senderName,
                            text: data.text,
                            time: data.time,
                            isSent: false
                        });

                        if (activeDirectContact && activeDirectContact.id === senderId) {
                            const feed = document.getElementById('direct-chat-feed');
                            if (feed) {
                                if (feed.querySelector('div[style*="text-align:center"]')) {
                                    feed.innerHTML = '';
                                }
                                const bubble = document.createElement('div');
                                bubble.className = 'chat-bubble received';
                                bubble.innerHTML = `
                                    <div style="font-size:11px; font-weight:700; color:var(--primary); margin-bottom:2px;">${escapeHtml(senderName)}</div>
                                    <div>${escapeHtml(data.text)}</div>
                                    <div style="font-size:10px; color:var(--on-surface-variant); text-align:right; margin-top:2px;">${data.time}</div>
                                `;
                                feed.appendChild(bubble);
                                feed.scrollTop = feed.scrollHeight;
                            }
                        } else {
                            showToast(`New message from ${senderName}: ${data.text.substring(0, 28)}...`);
                        }
                        renderDirectContacts();
                    } catch(e) {}
                    return;
                }
            });
        } catch (err) {}
    }

    function startRandomMatchmaking() {
        if (activeMediaCall) return;
        isSearchingRandom = true;
        showTopLoader();
        document.getElementById('call-status-heading').innerText = "Searching for Speaking Partners";
        document.getElementById('call-partner-meta').innerHTML = 'Matching by Target Band <span style="font-weight:700; color:var(--primary);">7.0 – 8.5</span> &amp; Cambridge Cue Cards';
        document.getElementById('searching-controls-row').style.display = 'flex';
        document.getElementById('call-in-progress-controls').style.display = 'none';
        document.getElementById('call-timer-display').style.display = 'none';
        document.getElementById('call-waveform-box').style.display = 'none';
        broadcastWaiting();
        if (searchInterval) clearInterval(searchInterval);
        searchInterval = setInterval(broadcastWaiting, 3000);
    }

    function broadcastWaiting() {
        if (!isSearchingRandom || !mqttClient) return;
        const myId = getOrCreatePermanentId();
        try {
            mqttClient.publish(MATCH_LOBBY_TOPIC, JSON.stringify({
                type: 'WAITING',
                peerId: myId,
                name: userProfile.name || 'Candidate',
                targetBand: userProfile.targetBand || 'Band 7.5',
                country: userProfile.country || 'Global',
                timestamp: Date.now()
            }));
        } catch (e) {}
    }

    function stopRandomMatchmaking() {
        isSearchingRandom = false;
        hideTopLoader();
        if (searchInterval) {
            clearInterval(searchInterval);
            searchInterval = null;
        }
    }

    function cancelMatchmaking() {
        stopRandomMatchmaking();
        hideTopLoader();
        document.getElementById('call-status-heading').innerText = "Matchmaking Paused";
        document.getElementById('call-partner-meta').innerText = "Tap Find Random Partner when ready to connect";
        showToast("Matchmaking paused");
    }

    function nextRandomPartner() {
        hangupActiveCall();
        showToast("Finding next practice partner...");
        startRandomMatchmaking();
    }

    /* -------------------------------------------------------------
       WEBRTC AUDIO ENGINE & IN-CALL MESSAGING
    ------------------------------------------------------------- */
    let peerInstance = null;
    let activeMediaCall = null;
    let activeDataConn = null;
    let localStream = null;
    let callTimerInterval = null;
    let secondsElapsed = 0;
    let incallUnreadCount = 0;

    let activePartnerId = null;
    let activePartnerName = null;
    let activePartnerBand = null;
    let activePartnerCountry = null;

    let carouselYear = 2026;
    let carouselQuestionsList = [];
    let currentCarouselIndex = 0;

    async function ensureLocalStream() {
        if (localStream) return localStream;
        try {
            localStream = await navigator.mediaDevices.getUserMedia({ audio: true, video: false });
            return localStream;
        } catch (err) {
            document.getElementById('call-status-heading').innerText = "Microphone Permission Required";
            showToast("Microphone access is required for audio calling");
            return null;
        }
    }

    async function initWebRtcEngine() {
        if (typeof Peer === 'undefined') {
            setTimeout(initWebRtcEngine, 300);
            return;
        }
        try {
            const permanentId = getOrCreatePermanentId();
            updateIdDisplays();

            peerInstance = new Peer(permanentId, {
                config: {
                    iceServers: [
                        { urls: 'stun:stun.l.google.com:19302' },
                        { urls: 'stun:stun1.l.google.com:19302' },
                        { urls: 'stun:global.stun.twilio.com:3478' }
                    ]
                }
            });

            peerInstance.on('open', (id) => {
                updateIdDisplays();
                initMqttMatchmaking();
            });

            peerInstance.on('call', async (call) => {
                stopRandomMatchmaking();
                activePartnerId = call.peer;
                activePartnerName = "Partner (" + call.peer.slice(-4) + ")";
                activeMediaCall = call;
                subscribeCallSessionTopic(call.peer);
                const stream = await ensureLocalStream();
                if (stream) {
                    call.answer(stream);
                    bindMediaCallStreams(call);
                }
            });

            peerInstance.on('connection', (conn) => {
                bindDataConnection(conn);
            });

        } catch (err) {}
    }

    function toggleIdControls() {
        const panel = document.getElementById('id-controls-panel');
        panel.style.display = panel.style.display === 'none' ? 'block' : 'none';
    }

    function startOutgoingCallManual() {
        const partnerId = document.getElementById('partner-id-input').value.trim();
        if (!partnerId) return alert("Please enter partner's Call ID");
        startOutgoingCallTo(partnerId, "Partner", "Band 7.5", "Global");
    }

    async function startOutgoingCallTo(targetId, name, band, country) {
        if (!peerInstance) return alert("WebRTC engine not ready. Check connection.");
        const stream = await ensureLocalStream();
        if (!stream) return;
        stopRandomMatchmaking();

        activePartnerId = targetId;
        activePartnerName = name || ("Partner (" + targetId.slice(-4) + ")");
        activePartnerBand = band || "Band 7.5";
        activePartnerCountry = country || "Global";

        document.getElementById('call-status-heading').innerText = "Connecting with partner...";
        document.getElementById('call-partner-meta').innerText = `${activePartnerName} (${activePartnerBand})`;

        const call = peerInstance.call(targetId, stream);
        activeMediaCall = call;
        bindMediaCallStreams(call);

        const conn = peerInstance.connect(targetId);
        bindDataConnection(conn);

        subscribeCallSessionTopic(targetId);
    }

    function bindMediaCallStreams(call) {
        subscribeCallSessionTopic(call.peer);
        call.on('stream', (remoteStream) => {
            document.getElementById('remoteAudio').srcObject = remoteStream;
            document.getElementById('call-status-heading').innerText = "Connected with Practice Partner";
            document.getElementById('call-partner-meta').innerText = activePartnerName ? `${activePartnerName} • ${activePartnerBand}` : "";
            document.getElementById('id-controls-panel').style.display = 'none';
            document.getElementById('searching-controls-row').style.display = 'none';
            document.getElementById('call-in-progress-controls').style.display = 'flex';
            document.getElementById('call-timer-display').style.display = 'block';
            document.getElementById('call-waveform-box').style.display = 'flex';

            selectCallYearFromSidebar(activeSpeakingYear);
            startCallTimer();
        });

        call.on('close', () => hangupActiveCall());
    }

    function bindDataConnection(conn) {
        activeDataConn = conn;
        conn.on('data', (data) => {
            if (data && data.type === 'CHAT_MSG') {
                if (data.msgId && processedCallMsgIds.has(data.msgId)) return;
                if (data.msgId) processedCallMsgIds.add(data.msgId);

                appendChatMessageToFeed(data.sender, data.text, data.time, false);

                const sheet = document.getElementById('incall-chat-sheet');
                if (!sheet.classList.contains('open')) {
                    incallUnreadCount++;
                    const badge = document.getElementById('call-unread-badge');
                    if (badge) badge.style.display = 'block';
                    showToast(`${data.sender}: ${data.text.substring(0, 25)}...`);
                }
            }
        });
    }

    function toggleCallMute() {
        if (localStream && localStream.getAudioTracks().length > 0) {
            const track = localStream.getAudioTracks()[0];
            track.enabled = !track.enabled;
            const btn = document.getElementById('call-mute-btn');
            btn.classList.toggle('muted', !track.enabled);
            showToast(track.enabled ? "Microphone Unmuted" : "Microphone Muted");
        }
    }

    function openInCallChatSheet() {
        document.getElementById('incall-chat-sheet').classList.add('open');
        incallUnreadCount = 0;
        document.getElementById('call-unread-badge').style.display = 'none';
    }

    function closeInCallChatSheet() {
        document.getElementById('incall-chat-sheet').classList.remove('open');
    }

    function sendInCallMessage() {
        const input = document.getElementById('incall-msg-input');
        const txt = input.value.trim();
        if (!txt) return;

        const timeStr = new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
        const senderName = userProfile.name || 'You';
        const myId = getOrCreatePermanentId();
        const msgId = 'callmsg_' + Date.now() + '_' + Math.random().toString(36).substring(2, 6);
        processedCallMsgIds.add(msgId);

        appendChatMessageToFeed(senderName, txt, timeStr, true);
        input.value = '';

        if (activeDataConn && activeDataConn.open) {
            try {
                activeDataConn.send({
                    msgId: msgId,
                    type: 'CHAT_MSG',
                    sender: senderName,
                    text: txt,
                    time: timeStr
                });
            } catch(e) {}
        }

        if (mqttClient && mqttClient.connected && activeCallChatTopic) {
            try {
                mqttClient.publish(activeCallChatTopic, JSON.stringify({
                    msgId: msgId,
                    senderId: myId,
                    senderName: senderName,
                    text: txt,
                    time: timeStr
                }));
            } catch(e) {}
        }
    }

    function appendChatMessageToFeed(sender, text, time, isSent) {
        const feed = document.getElementById('incall-chat-feed');
        const bubble = document.createElement('div');
        bubble.className = `chat-bubble ${isSent ? 'sent' : 'received'}`;
        bubble.innerHTML = `
            ${!isSent ? `<div style="font-size:11px; font-weight:700; color:var(--primary); margin-bottom:2px;">${sender}</div>` : ''}
            <div>${escapeHtml(text)}</div>
            <div style="font-size:10px; opacity:0.8; text-align:right; margin-top:2px;">${time}</div>
        `;
        feed.appendChild(bubble);
        feed.scrollTop = feed.scrollHeight;
    }

    function hangupActiveCall() {
        if (activeMediaCall) {
            activeMediaCall.close();
            activeMediaCall = null;
        }
        if (activeDataConn) {
            activeDataConn.close();
            activeDataConn = null;
        }
        unsubscribeCallSessionTopic();
        processedCallMsgIds.clear();
        clearInterval(callTimerInterval);
        document.getElementById('call-status-heading').innerText = "Call Ended";
        document.getElementById('call-partner-meta').innerText = "";
        document.getElementById('call-in-progress-controls').style.display = 'none';
        document.getElementById('call-timer-display').style.display = 'none';
        document.getElementById('call-waveform-box').style.display = 'none';
        document.getElementById('searching-controls-row').style.display = 'flex';
        document.getElementById('incall-carousel-section').style.display = 'none';
        document.getElementById('incall-chat-sheet').classList.remove('open');
        secondsElapsed = 0;
    }

    function startCallTimer() {
        clearInterval(callTimerInterval);
        secondsElapsed = 0;
        callTimerInterval = setInterval(() => {
            secondsElapsed++;
            const m = String(Math.floor(secondsElapsed / 60)).padStart(2, '0');
            const s = String(secondsElapsed % 60).padStart(2, '0');
            document.getElementById('call-timer-display').innerText = `${m}:${s}`;
        }, 1000);
    }

    function saveCurrentPartnerToContacts() {
        if (!activePartnerId) return showToast("No active partner to save");
        const contacts = getSavedContacts();
        if (!contacts.find(c => c.id === activePartnerId)) {
            contacts.unshift({
                id: activePartnerId,
                name: activePartnerName || ("Partner " + activePartnerId.slice(-4)),
                country: activePartnerCountry || "Global",
                targetBand: activePartnerBand || "Band 7.5",
                lastMsg: "Connected via Live Match",
                lastTime: new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })
            });
            saveContactsList(contacts);
            showToast("Partner saved to Direct Messages!");
            renderDirectContacts();
        } else {
            showToast("Partner is already in your Contacts!");
        }
    }

    /* -------------------------------------------------------------
       IN-CALL QUESTION CAROUSEL & DRAWER
    ------------------------------------------------------------- */
    function toggleSidebarDrawer() {
        document.getElementById('incall-sidebar-drawer').classList.toggle('open');
    }

    function renderInCallSidebarYears() {
        const list = document.getElementById('sidebar-years-list');
        list.innerHTML = allYears.map(yr => `
            <div class="filter-pill" style="display:block; text-align:left; margin-bottom:4px;" onclick="selectCallYearFromSidebar(${yr})">Year ${yr} (Cam ${getCambridgeBook(yr)})</div>
        `).join('');
    }

    function selectCallYearFromSidebar(year) {
        carouselYear = year;
        const paper = getSpeakingPaperData(year);
        carouselQuestionsList = [];
        paper.sets.forEach(set => {
            set.questions.forEach(q => {
                carouselQuestionsList.push({
                    title: `${set.setTitle} • ${q.qLabel}`,
                    prompt: q.prompt,
                    bullets: q.bullets
                });
            });
        });

        currentCarouselIndex = 0;
        document.getElementById('incall-sidebar-drawer').classList.remove('open');
        document.getElementById('incall-carousel-section').style.display = 'block';
        renderCarouselCard();
    }

    function renderCarouselCard() {
        if (!carouselQuestionsList.length) return;
        const q = carouselQuestionsList[currentCarouselIndex];
        document.getElementById('carousel-year-title').innerText = `${carouselYear} (${currentCarouselIndex + 1}/${carouselQuestionsList.length}): ${q.title}`;
        document.getElementById('carousel-card-body').innerHTML = `
            <p style="font-weight:700; margin-bottom:6px; color:var(--primary);">${q.prompt.replace(/\n/g, '<br/>')}</p>
        `;
    }

    function carouselPrev() {
        if (currentCarouselIndex > 0) {
            currentCarouselIndex--;
            renderCarouselCard();
        }
    }

    function carouselNext() {
        if (currentCarouselIndex < carouselQuestionsList.length - 1) {
            currentCarouselIndex++;
            renderCarouselCard();
        }
    }

    /* -------------------------------------------------------------
       TAB 4: DIRECT 1-ON-1 CHAT (100% PERSISTENT, ZERO DUMMY CHATS)
    ------------------------------------------------------------- */
    let activeDirectContact = null;

    function getSavedContacts() {
        try {
            return JSON.parse(localStorage.getItem('ielts_direct_contacts')) || [];
        } catch (e) {
            return [];
        }
    }

    function saveContactsList(list) {
        localStorage.setItem('ielts_direct_contacts', JSON.stringify(list));
    }

    function getChatMessages(contactId) {
        try {
            return JSON.parse(localStorage.getItem('ielts_chat_msgs_' + contactId)) || [];
        } catch (e) {
            return [];
        }
    }

    function saveChatMessage(contactId, msg) {
        const msgs = getChatMessages(contactId);
        msgs.push(msg);
        localStorage.setItem('ielts_chat_msgs_' + contactId, JSON.stringify(msgs));

        const contacts = getSavedContacts();
        const idx = contacts.findIndex(c => c.id === contactId);
        if (idx >= 0) {
            contacts[idx].lastMsg = msg.text;
            contacts[idx].lastTime = msg.time;
            saveContactsList(contacts);
        }
    }

    function renderDirectContacts() {
        const contacts = getSavedContacts();
        const container = document.getElementById('direct-contacts-list');
        const emptyState = document.getElementById('direct-empty-state');

        if (!contacts || contacts.length === 0) {
            container.innerHTML = '';
            emptyState.style.display = 'block';
            return;
        }

        emptyState.style.display = 'none';
        container.innerHTML = contacts.map(c => `
            <div class="chat-contact-card" onclick="openDirectChat('${c.id}')">
                <div class="chat-avatar-disc">${(c.name || 'P').charAt(0).toUpperCase()}</div>
                <div style="flex:1;">
                    <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:2px;">
                        <span style="font-weight:800; font-size:14px; color:var(--primary);">${escapeHtml(c.name)}</span>
                        <span style="font-size:11px; color:var(--on-surface-variant); font-weight:600;">${c.lastTime || ''}</span>
                    </div>
                    <div style="font-size:11px; color:var(--secondary); font-weight:700; margin-bottom:2px;">ID: ${c.id} • ${c.targetBand || 'Band 7.5'}</div>
                    <div style="font-size:12px; color:var(--on-surface-variant); white-space:nowrap; overflow:hidden; text-overflow:ellipsis; max-width:240px;">${escapeHtml(c.lastMsg || 'Tap to chat')}</div>
                </div>
            </div>
        `).join('');
    }

    function openDirectChat(contactId) {
        const contacts = getSavedContacts();
        const contact = contacts.find(c => c.id === contactId);
        if (!contact) return;
        activeDirectContact = contact;

        document.getElementById('direct-contacts-view').style.display = 'none';
        document.getElementById('direct-chat-window').classList.add('active');
        document.getElementById('chat-window-name').innerText = contact.name;
        document.getElementById('chat-window-status').innerText = `ID: ${contact.id} • ${contact.targetBand || 'Band 7.5'}`;

        const feed = document.getElementById('direct-chat-feed');
        feed.innerHTML = '';

        const messages = getChatMessages(contactId);
        if (messages.length === 0) {
            feed.innerHTML = `<div style="text-align:center; padding:30px; color:var(--on-surface-variant); font-size:12px;">No messages yet. Send a message to start practicing!</div>`;
        } else {
            messages.forEach(m => {
                const bubble = document.createElement('div');
                bubble.className = `chat-bubble ${m.isSent ? 'sent' : 'received'}`;
                bubble.innerHTML = `
                    ${!m.isSent ? `<div style="font-size:11px; font-weight:700; color:var(--primary); margin-bottom:2px;">${escapeHtml(contact.name)}</div>` : ''}
                    <div>${escapeHtml(m.text)}</div>
                    <div style="font-size:10px; opacity:0.8; text-align:right; margin-top:2px;">${m.time}</div>
                `;
                feed.appendChild(bubble);
            });
            feed.scrollTop = feed.scrollHeight;
        }
    }

    function closeDirectChatWindow() {
        document.getElementById('direct-chat-window').classList.remove('active');
        document.getElementById('direct-contacts-view').style.display = 'block';
        activeDirectContact = null;
        renderDirectContacts();
    }

    function sendDirectMsg() {
        if (!activeDirectContact) return;
        const input = document.getElementById('direct-msg-input');
        const txt = input.value.trim();
        if (!txt) return;

        const timeStr = new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
        const myId = getOrCreatePermanentId();
        const myName = userProfile.name || 'Practice Partner';

        const newMsg = {
            sender: "Me",
            text: txt,
            time: timeStr,
            isSent: true
        };

        saveChatMessage(activeDirectContact.id, newMsg);

        const feed = document.getElementById('direct-chat-feed');
        if (feed.querySelector('div[style*="text-align:center"]')) {
            feed.innerHTML = '';
        }
        const bubble = document.createElement('div');
        bubble.className = 'chat-bubble sent';
        bubble.innerHTML = `
            <div>${escapeHtml(txt)}</div>
            <div style="font-size:10px; opacity:0.8; text-align:right; margin-top:2px;">${timeStr}</div>
        `;
        feed.appendChild(bubble);
        feed.scrollTop = feed.scrollHeight;
        input.value = '';

        if (mqttClient && mqttClient.connected) {
            try {
                mqttClient.publish('ielts/dm/' + activeDirectContact.id, JSON.stringify({
                    senderId: myId,
                    senderName: myName,
                    senderBand: userProfile.targetBand || 'Band 7.5',
                    senderCountry: userProfile.country || 'Global',
                    text: txt,
                    time: timeStr,
                    timestamp: Date.now()
                }));
            } catch(e) {}
        }
    }

    function deleteCurrentChat() {
        if (!activeDirectContact) return;
        if (!confirm(`Delete conversation with ${activeDirectContact.name}?`)) return;

        let contacts = getSavedContacts().filter(c => c.id !== activeDirectContact.id);
        saveContactsList(contacts);
        localStorage.removeItem('ielts_chat_msgs_' + activeDirectContact.id);
        showToast("Conversation deleted");
        closeDirectChatWindow();
    }

    function callCurrentChatPartner() {
        if (!activeDirectContact) return;
        const partnerId = activeDirectContact.id;
        const name = activeDirectContact.name;
        const band = activeDirectContact.targetBand;
        switchTab('call');
        startOutgoingCallTo(partnerId, name, band, "Global");
    }

    function openAddPartnerModal() {
        document.getElementById('add-partner-modal').classList.add('open');
        document.getElementById('new-partner-id-input').value = '';
        document.getElementById('new-partner-name-input').value = '';
    }

    function closeAddPartnerModal() {
        document.getElementById('add-partner-modal').classList.remove('open');
    }

    function saveNewPartner() {
        const idInput = document.getElementById('new-partner-id-input').value.trim();
        if (!idInput) return alert("Please enter partner's Permanent IELTS ID");

        const nameInput = document.getElementById('new-partner-name-input').value.trim() || idInput;
        const bandInput = document.getElementById('new-partner-band-input').value.trim() || "Band 7.5";

        const contacts = getSavedContacts();
        const existing = contacts.find(c => c.id === idInput);
        if (!existing) {
            contacts.unshift({
                id: idInput,
                name: nameInput,
                targetBand: bandInput,
                lastMsg: "Added to contacts",
                lastTime: "Just now"
            });
            saveContactsList(contacts);
        }
        closeAddPartnerModal();
        renderDirectContacts();
        openDirectChat(idInput);
    }

    /* -------------------------------------------------------------
       TAB 5: CANDIDATE PROFILE
    ------------------------------------------------------------- */
    function setGender(g) {
        userProfile.gender = g;
        document.querySelectorAll('#gender-chips-container .filter-pill').forEach(btn => {
            btn.classList.toggle('active', btn.innerText === g);
        });
    }

    function setTargetBand(b) {
        userProfile.targetBand = b;
        document.querySelectorAll('#band-chips-container .filter-pill').forEach(btn => {
            btn.classList.toggle('active', btn.innerText === b);
        });
        const num = b.replace('Band ', '');
        const el = document.getElementById('header-band-badge');
        if (el) el.innerText = num;
        const elBento = document.getElementById('prof-bento-band');
        if (elBento) elBento.innerText = num;
    }

    function toggleEditProfileForm() {
        const f = document.getElementById('prof-form-card');
        if (f) {
            f.scrollIntoView({ behavior: 'smooth' });
        }
    }

    function saveCandidateProfile() {
        userProfile.name = document.getElementById('prof-name-input').value.trim() || 'Jhan Student';
        userProfile.age = document.getElementById('prof-age-input').value.trim() || '23';
        userProfile.country = document.getElementById('prof-country-input').value.trim() || 'Vietnam';

        localStorage.setItem('ielts_profile_config', JSON.stringify(userProfile));
        document.getElementById('prof-display-name').innerText = userProfile.name;
        document.getElementById('prof-display-country').innerText = `${userProfile.country} • Target ${userProfile.targetBand}`;
        showToast("Profile Settings Saved Successfully!");
    }

    function loadUserProfile() {
        const saved = localStorage.getItem('ielts_profile_config');
        if (saved) {
            try {
                userProfile = JSON.parse(saved);
                document.getElementById('prof-name-input').value = userProfile.name || 'Jhan Student';
                document.getElementById('prof-age-input').value = userProfile.age || '23';
                document.getElementById('prof-country-input').value = userProfile.country || 'Vietnam';
                document.getElementById('prof-display-name').innerText = userProfile.name || 'Jhan Student';
                document.getElementById('prof-display-country').innerText = `${userProfile.country || 'Vietnam'} • Target ${userProfile.targetBand || 'Band 7.5'}`;
                setGender(userProfile.gender || 'Male');
                setTargetBand(userProfile.targetBand || 'Band 7.5');
            } catch (e) {}
        }
    }

    /* -------------------------------------------------------------
       UTILITIES & DOM READY INITIALIZER
    ------------------------------------------------------------- */
    function showToast(msg) {
        const t = document.getElementById('global-toast');
        t.innerText = msg;
        t.style.display = 'block';
        setTimeout(() => { t.style.display = 'none'; }, 2800);
    }

    function copyTextToClipboard(text) {
        navigator.clipboard.writeText(text).then(() => {
            showToast("Copied to clipboard!");
        });
    }

    function escapeHtml(str) {
        if (!str) return "";
        return str.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
    }

    function escapeJs(str) {
        if (!str) return "";
        return str.replace(/'/g, "\\'").replace(/\n/g, "\\n");
    }

    function initApp() {
        hideTopLoader();
        loadUserProfile();
        updateIdDisplays();
        renderDirectContacts();
        renderInCallSidebarYears();
        setTimeout(initWebRtcEngine, 200);
    }

    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', initApp);
    } else {
        initApp();
    }
'@

$fullJs = $cambridgeJs + "`n" + $appJsLogic.Replace('@@LOTTIE_JSON@@', $lottieJson)

# -------------------------------------------------------------
# ASSEMBLE BLOGGER XML THEME
# -------------------------------------------------------------
$themeXml = @"
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html b:css='false' b:responsive='true' xmlns='http://www.w3.org/1999/xhtml' xmlns:b='http://www.google.com/2005/gml/b' xmlns:data='http://www.google.com/2005/gml/data' xmlns:expr='http://www.google.com/2005/gml/expr'>
<head>
    <meta charset='utf-8'/>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no' name='viewport'/>
    <meta content='yes' name='apple-mobile-web-app-capable'/>
    <meta content='default' name='apple-mobile-web-app-status-bar-style'/>
    <meta content='IELTS Speaking &amp; Peer Audio Prep' name='apple-mobile-web-app-title'/>
    <meta content='telephone=no' name='format-detection'/>
    <title><data:blog.pageTitle/></title>

    <!-- Google Fonts: Plus Jakarta Sans, Inter & Material Symbols -->
    <link href='https://fonts.googleapis.com' rel='preconnect'/>
    <link crossorigin='' href='https://fonts.gstatic.com' rel='preconnect'/>
    <link href='https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&amp;family=Plus+Jakarta+Sans:wght@500;600;700;800&amp;family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap' rel='stylesheet'/>

    <script src='https://unpkg.com/peerjs@1.5.4/dist/peerjs.min.js' defer='defer'></script>
    <script src='https://unpkg.com/mqtt@5.16.0/dist/mqtt.min.js' defer='defer'></script>

    <b:skin><![CDATA[
$css
    ]]></b:skin>
</head>
<body>

    <!-- REQUIRED BLOGGER SECTION -->
    <div style='display:none;'>
        <b:section id='main-blogger-content' showaddelement='no'>
            <b:widget id='Blog1' locked='true' title='Blog Posts' type='Blog'>
                <b:includable id='main'>
                    <b:loop values='data:posts' var='post'>
                        <div class='post-body'><data:post.body/></div>
                    </b:loop>
                </b:includable>
            </b:widget>
        </b:section>
    </div>

$bodyHtml

    <script>//<![CDATA[
$fullJs
    //]]></script>
</body>
</html>
"@

[System.IO.File]::WriteAllText($themeFile, $themeXml, [System.Text.Encoding]::UTF8)
Write-Host "Generated Modern Scholastic blogspot_theme.xml! Size: " (Get-Item $themeFile).Length

# -------------------------------------------------------------
# ASSEMBLE STANDALONE HTML5 APP
# -------------------------------------------------------------
$standaloneHtml = @"
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport"/>
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="default" name="apple-mobile-web-app-status-bar-style"/>
    <title>IELTS Speaking &amp; Peer Audio Prep (Cambridge Official Edition)</title>

    <!-- Google Fonts: Plus Jakarta Sans, Inter & Material Symbols -->
    <link href="https://fonts.googleapis.com" rel="preconnect"/>
    <link crossorigin="" href="https://fonts.gstatic.com" rel="preconnect"/>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&amp;family=Plus+Jakarta+Sans:wght@500;600;700;800&amp;family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>

    <script src="https://unpkg.com/peerjs@1.5.4/dist/peerjs.min.js" defer="defer"></script>
    <script src="https://unpkg.com/mqtt@5.16.0/dist/mqtt.min.js" defer="defer"></script>

    <style>
$css
    </style>
</head>
<body>

$bodyHtml

    <script>
$fullJs
    </script>
</body>
</html>
"@

[System.IO.File]::WriteAllText($htmlFile, $standaloneHtml, [System.Text.Encoding]::UTF8)
Write-Host "Generated Modern Scholastic blogspot_app.html! Size: " (Get-Item $htmlFile).Length

# -------------------------------------------------------------
# VERIFY XML PARSER VALIDITY
# -------------------------------------------------------------
$doc = New-Object System.Xml.XmlDocument
$doc.Load($themeFile)
Write-Host "XML VALIDATION SUCCESS! Root Element: " $doc.DocumentElement.Name
