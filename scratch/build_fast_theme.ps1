# Fast Theme Builder with Pre-rendered HTML Cards, Async Images, and Instant Navigation
$ErrorActionPreference = 'Stop'

$themeFile = 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_theme.xml'
$htmlFile = 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_app.html'
$lottieJson = [System.IO.File]::ReadAllText('C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\switchusercards.json')

# Load base content from blogspot_theme.xml to get the Cambridge test database
$existingXml = [System.IO.File]::ReadAllText($themeFile)

# Extract CSS from existing theme
$cssStart = $existingXml.IndexOf('<b:skin><![CDATA[') + 17
$cssEnd = $existingXml.IndexOf(']]></b:skin>')
$baseCss = $existingXml.Substring($cssStart, $cssEnd - $cssStart)

# Extract Speaking & Writing Cambridge Data Generator JS functions
$jsDataStart = $existingXml.IndexOf('const allYears = Array.from')
$jsDataEnd = $existingXml.IndexOf('/* -------------------------------------------------------------`r`n       TAB 3: LOTTIE')
if ($jsDataEnd -lt 0) {
    $jsDataEnd = $existingXml.IndexOf('/* -------------------------------------------------------------`n       TAB 3: LOTTIE')
}
if ($jsDataEnd -lt 0) {
    $jsDataEnd = $existingXml.IndexOf('TAB 3: LOTTIE')
    $jsDataEnd = $existingXml.LastIndexOf('/*', $jsDataEnd)
}
$cambridgeDataJs = $existingXml.Substring($jsDataStart, $jsDataEnd - $jsDataStart)

# Additional CSS rules for top loader, skeleton shimmer, and animations
$extraCss = @'

    /* Top Page Loader Bar */
    .top-loader-bar {
        position: fixed;
        top: 0;
        left: 0;
        height: 3px;
        width: 100%;
        background: linear-gradient(90deg, #38bdf8, #818cf8, #06b6d4, #38bdf8);
        background-size: 200% 100%;
        animation: loaderSlide 1s infinite linear;
        z-index: 9999;
        opacity: 0;
        transition: opacity 0.3s ease;
        pointer-events: none;
    }
    .top-loader-bar.active {
        opacity: 1;
    }
    @keyframes loaderSlide {
        0% { background-position: 200% 0; }
        100% { background-position: -200% 0; }
    }
    .cancel-load-pill {
        background: rgba(239, 68, 68, 0.18);
        color: #f87171;
        border: 1px solid rgba(239, 68, 68, 0.4);
        padding: 5px 12px;
        border-radius: 9999px;
        font-size: 0.75rem;
        font-weight: 700;
        cursor: pointer;
        display: inline-flex;
        align-items: center;
        gap: 5px;
        transition: all 0.2s ease;
    }
    .cancel-load-pill:hover {
        background: rgba(239, 68, 68, 0.32);
    }

    /* Skeleton Image Placeholder & Async Fade-In */
    .img-skeleton {
        width: 100%;
        background: linear-gradient(110deg, #1e293b 8%, #334155 18%, #1e293b 33%);
        background-size: 200% 100%;
        animation: skeletonShimmer 1.5s linear infinite;
        position: relative;
        overflow: hidden;
    }
    @keyframes skeletonShimmer {
        0% { background-position: 200% 0; }
        100% { background-position: -200% 0; }
    }
    .staggered-img {
        width: 100%;
        height: 100%;
        object-fit: cover;
        display: block;
        opacity: 0;
        transition: opacity 0.4s ease-in-out;
    }
    .staggered-img.loaded {
        opacity: 1;
    }

    /* Empty State Box */
    .empty-state-box {
        text-align: center;
        padding: 40px 20px;
        color: var(--text-muted);
    }
    .empty-state-icon {
        width: 72px;
        height: 72px;
        border-radius: 50%;
        background: rgba(56, 189, 248, 0.12);
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 1.8rem;
        color: var(--primary);
        margin: 0 auto 16px auto;
    }

    /* Modal Dialog */
    .modal-overlay {
        display: none;
        position: fixed;
        top: 0; left: 0; right: 0; bottom: 0;
        background: rgba(0, 0, 0, 0.75);
        backdrop-filter: blur(8px);
        -webkit-backdrop-filter: blur(8px);
        z-index: 200;
        align-items: center;
        justify-content: center;
        padding: 20px;
    }
    .modal-overlay.open { display: flex; }

    .modal-card {
        background: #1e293b;
        border: 1px solid var(--border-active);
        border-radius: 24px;
        padding: 24px;
        max-width: 440px;
        width: 100%;
        box-shadow: var(--shadow);
    }

    .my-id-pill {
        background: rgba(56, 189, 248, 0.12);
        border: 1px solid rgba(56, 189, 248, 0.3);
        color: #38bdf8;
        font-size: 0.75rem;
        font-weight: 800;
        font-family: monospace;
        padding: 6px 12px;
        border-radius: 12px;
        display: flex;
        align-items: center;
        gap: 6px;
        cursor: pointer;
        transition: all 0.2s;
    }
    .my-id-pill:hover {
        background: rgba(56, 189, 248, 0.22);
    }

    .search-action-btn {
        padding: 12px 18px;
        border-radius: 14px;
        font-weight: 800;
        font-size: 0.88rem;
        cursor: pointer;
        display: inline-flex;
        align-items: center;
        gap: 8px;
        transition: transform 0.2s, background 0.2s;
        border: none;
    }
    .search-action-btn:hover {
        transform: translateY(-2px);
    }
    .btn-search-random {
        background: var(--primary-gradient);
        color: white;
        box-shadow: 0 4px 15px var(--primary-glow);
    }
    .btn-toggle-dial {
        background: #334155;
        color: white;
    }

    .btn-circle.btn-skip-call {
        background: #0284c7;
        color: white;
    }
    .btn-circle.btn-save-contact {
        background: #059669;
        color: white;
    }
'@

$fullCss = $baseCss + $extraCss

# Build pre-rendered static HTML cards for 26 years
$heights = @(135, 175, 145, 185, 150, 170)
$speakingImages = @(
    'https://images.unsplash.com/photo-1618005182384-a83a8bd57fbe?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1477959858617-67f30bc75b82?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1518709268805-4e9042af9f23?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1523240795612-9a054b0db644?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1470071459604-3b5ec3a7fe05?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1451187580459-43490279c0fa?w=400&amp;auto=format&amp;fit=crop&amp;q=75'
)
$writingImages = @(
    'https://images.unsplash.com/photo-1551288049-bebda4e38f71?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1542601906990-b4d3fb778b09?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1434030216411-0b793f4b4173?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1455390582262-044cdead277a?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1488190211105-8b0e65b80b4e?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1586075010923-2dd4570fb338?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1518770660439-4636190af475?w=400&amp;auto=format&amp;fit=crop&amp;q=75',
    'https://images.unsplash.com/photo-1444723121867-7a241cacace9?w=400&amp;auto=format&amp;fit=crop&amp;q=75'
)

$sbSpeakingCards = New-Object System.Text.StringBuilder
$sbWritingCards = New-Object System.Text.StringBuilder

for ($i = 0; $i -lt 26; $i++) {
    $yr = 2026 - $i
    $h = $heights[$i % $heights.Length]
    $spImg = $speakingImages[$i % $speakingImages.Length]
    $wrImg = $writingImages[$i % $writingImages.Length]

    [void]$sbSpeakingCards.AppendLine("                <div class='staggered-card' onclick='openSpeakingYear($yr)'>")
    [void]$sbSpeakingCards.AppendLine("                    <div class='img-skeleton' style='height:${h}px;'>")
    [void]$sbSpeakingCards.AppendLine("                        <img src='$spImg' alt='IELTS $yr' class='staggered-img' loading='lazy' decoding='async' onload='markLoaded(this)' onerror='handleImgError(this)'/>")
    [void]$sbSpeakingCards.AppendLine("                    </div>")
    [void]$sbSpeakingCards.AppendLine("                    <div class='staggered-badge-box'>")
    [void]$sbSpeakingCards.AppendLine("                        <span class='year-pill'>$yr</span>")
    [void]$sbSpeakingCards.AppendLine("                    </div>")
    [void]$sbSpeakingCards.AppendLine("                </div>")

    [void]$sbWritingCards.AppendLine("                <div class='staggered-card' onclick='openWritingYear($yr)'>")
    [void]$sbWritingCards.AppendLine("                    <div class='img-skeleton' style='height:${h}px;'>")
    [void]$sbWritingCards.AppendLine("                        <img src='$wrImg' alt='Writing $yr' class='staggered-img' loading='lazy' decoding='async' onload='markLoaded(this)' onerror='handleImgError(this)'/>")
    [void]$sbWritingCards.AppendLine("                    </div>")
    [void]$sbWritingCards.AppendLine("                    <div class='staggered-badge-box'>")
    [void]$sbWritingCards.AppendLine("                        <span class='year-pill'>$yr</span>")
    [void]$sbWritingCards.AppendLine("                    </div>")
    [void]$sbWritingCards.AppendLine("                </div>")
}

$speakingCardsHtml = $sbSpeakingCards.ToString()
$writingCardsHtml = $sbWritingCards.ToString()

# Build HTML Body with Top Loader and Immediate ID Init
$bodyHtml = @"
    <!-- TOP PROGRESS LOADER -->
    <div id='top-page-loader' class='top-loader-bar active'></div>

    <!-- MAIN APP HEADER -->
    <header class='app-header'>
        <div class='brand-title'>
            <i class='fa-solid fa-graduation-cap' style='color:#38bdf8;'></i>
            <span>IELTS Prep Pro</span>
            <span id='header-subtitle' style='font-size:0.75rem; font-weight:600; color:var(--text-muted); margin-left:4px;'>Cambridge Official</span>
        </div>
        <div class='header-actions'>
            <button class='cancel-load-pill' id='cancel-load-btn' onclick='cancelAllLoading()' title='Cancel pending background loading' style='display:none;'>
                <i class='fa-solid fa-ban'></i> Cancel
            </button>
            <div class='my-id-pill' onclick='copyPermanentId()' title='Click to copy your Permanent Call ID'>
                <i class='fa-solid fa-id-badge'></i>
                <span id='header-my-id'>IELTS ID</span>
            </div>
            <button class='header-btn' id='key-toggle-btn' onclick='toggleIdControls()' aria-label='Toggle ID Controls' title='Enter Partner Call ID'>
                <i class='fa-solid fa-key'></i>
            </button>
        </div>
    </header>

    <!-- SYNCHRONOUS INLINE INITIALIZER: SETS PERMANENT ID INSTANTLY WITH ZERO LOADING DELAY -->
    <script>//<![CDATA[
        function markLoaded(img) {
            if (!img) return;
            img.classList.add('loaded');
            var p = img.parentElement;
            if (p && p.classList.contains('img-skeleton')) {
                p.style.animation = 'none';
            }
        }
        function handleImgError(img) {
            if (!img) return;
            img.style.display = 'none';
            var p = img.parentElement;
            if (p && p.classList.contains('img-skeleton')) {
                p.style.animation = 'none';
                p.style.background = '#1e293b';
            }
        }
        try {
            var _pId = localStorage.getItem('ielts_permanent_id');
            if (!_pId) {
                _pId = 'ielts-' + Math.random().toString(36).substring(2, 8).toUpperCase();
                localStorage.setItem('ielts_permanent_id', _pId);
            }
            var _el = document.getElementById('header-my-id');
            if (_el) _el.innerText = _pId;
        } catch(e) {}
    //]]></script>

    <!-- MAIN BODY CONTAINER -->
    <main class='app-main'>

        <!-- ========================================== -->
        <!-- TAB 1: SPEAKING (Pre-rendered for Instant Load) -->
        <!-- ========================================== -->
        <div id='tab-speaking' class='tab-content'>
            <div id='speaking-grid-view'>
                <div style='margin-bottom:14px;'>
                    <h2 style='font-size:1.15rem; font-weight:800; color:#38bdf8;'>Speaking Question Papers</h2>
                    <p style='font-size:0.82rem; color:var(--text-muted);'>Authentic Cambridge IELTS Tests (Years 2026 – 2001)</p>
                </div>
                <div class='staggered-grid' id='speaking-staggered-container'>
$speakingCardsHtml
                </div>
            </div>

            <div id='speaking-detail-view' class='detail-view'>
                <div class='detail-header-card'>
                    <button class='back-btn' onclick='closeSpeakingDetail()' aria-label='Back to Speaking List'><i class='fa-solid fa-arrow-left'></i></button>
                    <div>
                        <h2 style='font-size:1.15rem; font-weight:800; color:white;' id='speaking-detail-header'>Cambridge Speaking Paper</h2>
                        <span style='font-size:0.78rem; color:#38bdf8; font-weight:700;'>4 Official Cambridge Test Sets</span>
                    </div>
                </div>

                <div class='set-pills-row' id='speaking-set-pills'></div>
                <div id='speaking-questions-container'></div>
            </div>
        </div>

        <!-- ========================================== -->
        <!-- TAB 2: WRITING (Pre-rendered for Instant Load)  -->
        <!-- ========================================== -->
        <div id='tab-writing' class='tab-content' style='display:none;'>
            <div id='writing-grid-view'>
                <div style='margin-bottom:14px;'>
                    <h2 style='font-size:1.15rem; font-weight:800; color:#38bdf8;'>Writing Tasks &amp; Essays</h2>
                    <p style='font-size:0.82rem; color:var(--text-muted);'>Official Cambridge Academic Task 1 &amp; Discursive Task 2</p>
                </div>
                <div class='staggered-grid' id='writing-staggered-container'>
$writingCardsHtml
                </div>
            </div>

            <div id='writing-detail-view' class='detail-view'>
                <div class='detail-header-card'>
                    <button class='back-btn' onclick='closeWritingDetail()' aria-label='Back to Writing List'><i class='fa-solid fa-arrow-left'></i></button>
                    <div>
                        <h2 style='font-size:1.15rem; font-weight:800; color:white;' id='writing-detail-header'>Cambridge Writing Paper</h2>
                        <span style='font-size:0.78rem; color:#38bdf8; font-weight:700;'>4 Official Cambridge Tasks &amp; Band 9 Answers</span>
                    </div>
                </div>

                <div class='set-pills-row' id='writing-set-pills'></div>
                <div id='writing-questions-container'></div>

                <!-- Essay Sandbox -->
                <div style='background:var(--card-gradient); border:1px solid var(--border); border-radius:20px; padding:18px; margin-top:20px;'>
                    <div style='display:flex; justify-content:space-between; align-items:center; margin-bottom:10px;'>
                        <h4 style='font-size:0.95rem; font-weight:800; color:#38bdf8;'><i class='fa-solid fa-keyboard'></i> Essay Practice Sandbox</h4>
                        <span id='writing-word-count' style='font-size:0.82rem; font-weight:800; color:#38bdf8;'>0 words</span>
                    </div>
                    <textarea id='essay-sandbox' placeholder='Type your practice essay or task 1 report here...' oninput='onSandboxInput()' style='width:100%; height:160px; background:#0f172a; border:1px solid var(--border); border-radius:12px; padding:12px; color:white; font-size:0.92rem; outline:none; resize:vertical;'></textarea>
                </div>
            </div>
        </div>

        <!-- ========================================== -->
        <!-- TAB 3: LIVE AUDIO CALL (Random Matchmaker) -->
        <!-- ========================================== -->
        <div id='tab-call' class='tab-content' style='display:none;'>
            <div class='call-view-card'>

                <!-- LOTTIE ANIMATION CONTAINER (Cards Switching) -->
                <div id='lottie-call-container' style='width:220px; height:220px; margin:0 auto 12px auto;'></div>

                <h3 id='call-status-heading' style='font-size:1.25rem; font-weight:800; color:white;'>Searching for practice partner...</h3>
                <div id='call-partner-meta' style='font-size:0.85rem; color:#38bdf8; font-weight:700; margin-top:4px;'></div>
                <div class='call-duration' id='call-timer-display' style='display:none;'>00:00</div>

                <!-- Searching Controls Row (Before Connected) with Cancel Button -->
                <div id='searching-controls-row' style='display:flex; justify-content:center; gap:8px; margin-top:18px; flex-wrap:wrap;'>
                    <button class='search-action-btn btn-search-random' onclick='startRandomMatchmaking()'>
                        <i class='fa-solid fa-rotate'></i> Find Random Partner
                    </button>
                    <button class='search-action-btn' onclick='cancelMatchmaking()' style='background:rgba(239,68,68,0.18); color:#f87171; border:1px solid rgba(239,68,68,0.4);' title='Cancel Active Search'>
                        <i class='fa-solid fa-xmark'></i> Cancel Search
                    </button>
                    <button class='search-action-btn btn-toggle-dial' onclick='toggleIdControls()'>
                        <i class='fa-solid fa-phone'></i> Call By ID
                    </button>
                </div>

                <!-- ID Controls Box (Toggled via Key icon or Call by ID) -->
                <div class='id-controls-card' id='id-controls-panel'>
                    <div style='display:flex; justify-content:space-between; align-items:center; margin-bottom:8px;'>
                        <span style='font-size:0.8rem; font-weight:800; color:#38bdf8;'>Your Permanent Call ID:</span>
                        <span style='font-size:0.7rem; color:#10b981; font-weight:700;'>● Persistent Across Sessions</span>
                    </div>
                    <div style='background:#0f172a; border:1px solid rgba(56,189,248,0.25); border-radius:10px; padding:10px 14px; font-family:monospace; font-weight:800; color:#38bdf8; font-size:0.95rem; margin-bottom:10px; word-break:break-all;' id='my-peer-id-text'>ielts-...</div>
                    <div style='display:flex; gap:8px; margin-bottom:14px;'>
                        <button class='btn-copy' onclick='copyPermanentId()' style='flex:1; justify-content:center;'><i class='fa-regular fa-copy'></i> Copy ID</button>
                        <button class='btn-copy' onclick='sharePermanentId()' style='flex:1; justify-content:center; background:#0284c7;'><i class='fa-solid fa-share-nodes'></i> Share Link</button>
                    </div>

                    <div style='border-top:1px solid var(--border); padding-top:12px;'>
                        <span style='font-size:0.8rem; font-weight:800; color:#f8fafc; display:block; margin-bottom:6px;'>Call Partner by Permanent ID:</span>
                        <input type='text' id='partner-id-input' placeholder='Paste partner permanent ID here (e.g. ielts-4X9B21)' style='width:100%; padding:12px; background:#0f172a; border:1px solid #334155; border-radius:10px; color:white; font-family:monospace; margin-bottom:8px; outline:none;'/>
                        <button onclick='startOutgoingCallManual()' style='width:100%; padding:12px; background:var(--primary-gradient); color:white; border:none; border-radius:10px; font-weight:800; cursor:pointer;'>
                            <i class='fa-solid fa-phone'></i> Direct Call
                        </button>
                    </div>
                </div>

                <!-- In-Call Circular Controls (When Connected) -->
                <div class='call-actions-row' id='call-in-progress-controls' style='display:none;'>
                    <button class='btn-circle btn-mute-call' id='call-mute-btn' onclick='toggleCallMute()' aria-label='Toggle Microphone Mute' title='Mute/Unmute'><i class='fa-solid fa-microphone'></i></button>
                    <button class='btn-circle btn-chat-call' onclick='openInCallChatSheet()' aria-label='Open Live Text Chat' title='Live In-Call Chat'>
                        <i class='fa-solid fa-message'></i>
                        <span class='unread-badge' id='call-unread-badge'></span>
                    </button>
                    <button class='btn-circle btn-skip-call' onclick='nextRandomPartner()' aria-label='Next Random Partner' title='Skip / Next Partner'><i class='fa-solid fa-forward-step'></i></button>
                    <button class='btn-circle btn-save-contact' onclick='saveCurrentPartnerToContacts()' aria-label='Save Partner to Direct Chat' title='Save Partner'><i class='fa-solid fa-bookmark'></i></button>
                    <button class='btn-circle btn-hangup-call' onclick='hangupActiveCall()' aria-label='End Audio Call' title='End Call'><i class='fa-solid fa-phone-slash'></i></button>
                </div>
            </div>

            <!-- In-Call Real-Time Cue Card Carousel -->
            <div class='carousel-section' id='incall-carousel-section'>
                <div style='display:flex; justify-content:space-between; align-items:center; margin-bottom:10px;'>
                    <h4 style='font-size:0.95rem; font-weight:800; color:#38bdf8;' id='carousel-year-title'>Question Cards</h4>
                    <div>
                        <button onclick='carouselPrev()' style='background:#334155; color:white; border:none; padding:6px 12px; border-radius:6px; cursor:pointer; margin-right:4px;' aria-label='Previous Question Card'><i class='fa-solid fa-chevron-left'></i></button>
                        <button onclick='carouselNext()' style='background:#334155; color:white; border:none; padding:6px 12px; border-radius:6px; cursor:pointer;' aria-label='Next Question Card'><i class='fa-solid fa-chevron-right'></i></button>
                    </div>
                </div>
                <div id='carousel-card-body' style='line-height:1.6; font-size:0.92rem; color:#e2e8f0;'></div>
            </div>
        </div>

        <!-- ========================================== -->
        <!-- TAB 4: 1-ON-1 DIRECT PERSONAL CHAT         -->
        <!-- ========================================== -->
        <div id='tab-chat' class='tab-content' style='display:none;'>
            <!-- Contacts List View -->
            <div id='direct-contacts-view'>
                <!-- Permanent ID Banner in Chat -->
                <div style='background:rgba(30,41,59,0.7); border:1px solid var(--border); border-radius:18px; padding:14px 16px; margin-bottom:16px; display:flex; justify-content:space-between; align-items:center;'>
                    <div>
                        <div style='font-size:0.75rem; color:var(--text-muted); font-weight:700;'>Your Permanent IELTS ID:</div>
                        <div style='font-family:monospace; font-size:1.05rem; font-weight:800; color:#38bdf8;' id='chat-my-permanent-id'>ielts-...</div>
                    </div>
                    <button class='btn-copy' onclick='copyPermanentId()'><i class='fa-regular fa-copy'></i> Copy ID</button>
                </div>

                <div style='display:flex; justify-content:space-between; align-items:center; margin-bottom:12px;'>
                    <div>
                        <h2 style='font-size:1.15rem; font-weight:800; color:#38bdf8;'>Direct Practice Messages</h2>
                        <p style='font-size:0.8rem; color:var(--text-muted);'>Chat history is saved permanently on your device</p>
                    </div>
                    <button class='btn-copy' onclick='openAddPartnerModal()' style='background:var(--primary-gradient); padding:8px 14px;'>
                        <i class='fa-solid fa-user-plus'></i> Add Partner
                    </button>
                </div>

                <!-- Empty State (No dummy chats) -->
                <div id='direct-empty-state' class='empty-state-box' style='display:none;'>
                    <div class='empty-state-icon'><i class='fa-solid fa-comments'></i></div>
                    <h3 style='font-size:1.05rem; font-weight:800; color:white; margin-bottom:6px;'>No Direct Chats Yet</h3>
                    <p style='font-size:0.84rem; max-width:360px; margin:0 auto 18px auto; line-height:1.5;'>
                        Messages and partner IDs are saved permanently. Connect with a study partner using their IELTS ID or save them from Live Match.
                    </p>
                    <button class='search-action-btn btn-search-random' onclick='openAddPartnerModal()'>
                        <i class='fa-solid fa-user-plus'></i> Add Practice Partner
                    </button>
                </div>

                <div id='direct-contacts-list'></div>
            </div>

            <!-- Direct 1-on-1 Chat Conversation Window -->
            <div id='direct-chat-window' class='direct-chat-window'>
                <div style='display:flex; justify-content:space-between; align-items:center; padding:10px 0; border-bottom:1px solid var(--border); margin-bottom:12px;'>
                    <div style='display:flex; align-items:center; gap:10px;'>
                        <button class='back-btn' onclick='closeDirectChatWindow()' style='width:36px; height:36px;' aria-label='Back to Contacts List'><i class='fa-solid fa-arrow-left'></i></button>
                        <div>
                            <h3 style='font-size:1rem; font-weight:800; color:white;' id='chat-window-name'>Partner</h3>
                            <span style='font-size:0.75rem; color:#38bdf8;' id='chat-window-status'>ID: ielts-...</span>
                        </div>
                    </div>
                    <div style='display:flex; gap:8px;'>
                        <button onclick='callCurrentChatPartner()' class='btn-copy' style='background:var(--primary-gradient);'><i class='fa-solid fa-phone'></i> Call</button>
                        <button onclick='deleteCurrentChat()' class='btn-copy' style='background:rgba(239,68,68,0.2); border-color:#ef4444; color:#ef4444;' title='Delete Conversation'><i class='fa-solid fa-trash'></i></button>
                    </div>
                </div>

                <div class='chat-feed-box' id='direct-chat-feed'></div>

                <div style='display:flex; gap:8px; padding-top:10px;'>
                    <input type='text' id='direct-msg-input' placeholder='Type message here...' onkeydown='if(event.key==="Enter")sendDirectMsg()' style='flex:1; padding:12px 14px; background:#0f172a; border:1px solid #334155; border-radius:12px; color:white; outline:none;'/>
                    <button onclick='sendDirectMsg()' style='padding:12px 18px; background:#0284c7; color:white; border:none; border-radius:12px; font-weight:700; cursor:pointer;' aria-label='Send Message'><i class='fa-solid fa-paper-plane'></i></button>
                </div>
            </div>
        </div>

        <!-- ========================================== -->
        <!-- TAB 5: PROFILE SETUP                       -->
        <!-- ========================================== -->
        <div id='tab-profile' class='tab-content' style='display:none;'>
            <h2 style='font-size:1.15rem; font-weight:800; color:#38bdf8; margin-bottom:4px;'>IELTS Practice Profile</h2>
            <p style='font-size:0.82rem; color:var(--text-muted); margin-bottom:18px;'>Manage your permanent candidate ID &amp; speaking practice profile</p>

            <!-- Permanent ID Card in Profile -->
            <div class='question-card' style='margin-bottom:18px;'>
                <div style='display:flex; justify-content:space-between; align-items:center; margin-bottom:8px;'>
                    <span style='font-size:0.85rem; font-weight:800; color:#38bdf8;'><i class='fa-solid fa-fingerprint'></i> Permanent Candidate ID</span>
                    <button class='btn-copy' onclick='toggleEditCustomId()'><i class='fa-solid fa-pen'></i> Edit Custom ID</button>
                </div>
                <div style='font-family:monospace; font-size:1.25rem; font-weight:800; color:white; margin:8px 0;' id='prof-permanent-id-text'>ielts-...</div>
                <p style='font-size:0.78rem; color:var(--text-muted); margin-bottom:12px;'>Share this permanent ID with study partners to receive direct calls and messages anytime.</p>

                <div id='edit-custom-id-box' style='display:none; margin-bottom:12px;'>
                    <input type='text' id='custom-id-input' placeholder='Set custom ID (e.g. ielts-john2026)' style='width:100%; padding:10px; background:#0f172a; border:1px solid #334155; border-radius:10px; color:white; font-family:monospace; margin-bottom:8px; outline:none;'/>
                    <button onclick='saveCustomPermanentId()' style='padding:8px 16px; background:#0284c7; color:white; border:none; border-radius:10px; font-weight:700; cursor:pointer;'>Save New Permanent ID</button>
                </div>

                <button class='btn-copy' onclick='copyPermanentId()' style='width:100%; justify-content:center; padding:10px;'><i class='fa-regular fa-copy'></i> Copy Permanent ID</button>
            </div>

            <div style='display:flex; justify-content:center; margin-bottom:18px;'>
                <div style='width:80px; height:80px; border-radius:50%; background:var(--primary-gradient); display:flex; align-items:center; justify-content:center; font-size:2rem; color:white;'>
                    <i class='fa-solid fa-user'></i>
                </div>
            </div>

            <div class='question-card' style='cursor:default;'>
                <label style='display:block; font-size:0.82rem; font-weight:700; margin-bottom:6px;'>Candidate Name</label>
                <input type='text' id='prof-name-input' value='Jhan Student' style='width:100%; padding:12px; background:#0f172a; border:1px solid #334155; border-radius:12px; color:white; margin-bottom:14px; outline:none;'/>

                <label style='display:block; font-size:0.82rem; font-weight:700; margin-bottom:6px;'>Age</label>
                <input type='number' id='prof-age-input' value='23' style='width:100%; padding:12px; background:#0f172a; border:1px solid #334155; border-radius:12px; color:white; margin-bottom:14px; outline:none;'/>

                <label style='display:block; font-size:0.82rem; font-weight:700; margin-bottom:6px;'>Country</label>
                <input type='text' id='prof-country-input' value='Vietnam' style='width:100%; padding:12px; background:#0f172a; border:1px solid #334155; border-radius:12px; color:white; margin-bottom:14px; outline:none;'/>

                <label style='display:block; font-size:0.82rem; font-weight:700; margin-bottom:6px;'>Gender</label>
                <div style='display:flex; gap:8px; margin-bottom:14px;' id='gender-chips-container'>
                    <button type='button' class='set-pill active' onclick='setGender("Male")'>Male</button>
                    <button type='button' class='set-pill' onclick='setGender("Female")'>Female</button>
                    <button type='button' class='set-pill' onclick='setGender("Other")'>Other</button>
                </div>

                <label style='display:block; font-size:0.82rem; font-weight:700; margin-bottom:6px;'>Target Band Score</label>
                <div style='display:flex; gap:6px; flex-wrap:wrap; margin-bottom:18px;' id='band-chips-container'>
                    <button type='button' class='set-pill' onclick='setTargetBand("Band 6.5")'>Band 6.5</button>
                    <button type='button' class='set-pill' onclick='setTargetBand("Band 7.0")'>Band 7.0</button>
                    <button type='button' class='set-pill active' onclick='setTargetBand("Band 7.5")'>Band 7.5</button>
                    <button type='button' class='set-pill' onclick='setTargetBand("Band 8.0")'>Band 8.0</button>
                    <button type='button' class='set-pill' onclick='setTargetBand("Band 8.5")'>Band 8.5</button>
                    <button type='button' class='set-pill' onclick='setTargetBand("Band 9.0")'>Band 9.0</button>
                </div>

                <button onclick='saveCandidateProfile()' style='width:100%; padding:14px; background:var(--primary-gradient); color:white; border:none; border-radius:14px; font-weight:800; cursor:pointer;'>
                    Save Candidate Profile
                </button>
            </div>
        </div>

    </main>

    <!-- MODAL: ADD PRACTICE PARTNER BY PERMANENT ID -->
    <div class='modal-overlay' id='add-partner-modal'>
        <div class='modal-card'>
            <div style='display:flex; justify-content:space-between; align-items:center; margin-bottom:14px;'>
                <h3 style='font-size:1.1rem; font-weight:800; color:#38bdf8;'><i class='fa-solid fa-user-plus'></i> Add Practice Partner</h3>
                <button onclick='closeAddPartnerModal()' style='background:none; border:none; color:var(--text-muted); font-size:1.2rem; cursor:pointer;'>✕</button>
            </div>
            <p style='font-size:0.82rem; color:var(--text-muted); margin-bottom:14px;'>Enter your partner's permanent IELTS ID to chat and practice speaking anytime.</p>

            <label style='display:block; font-size:0.8rem; font-weight:700; margin-bottom:4px;'>Partner's Permanent ID *</label>
            <input type='text' id='new-partner-id-input' placeholder='e.g. ielts-4X9B21' style='width:100%; padding:12px; background:#0f172a; border:1px solid #334155; border-radius:12px; color:white; font-family:monospace; margin-bottom:12px; outline:none;'/>

            <label style='display:block; font-size:0.8rem; font-weight:700; margin-bottom:4px;'>Partner's Name (Optional)</label>
            <input type='text' id='new-partner-name-input' placeholder='e.g. Sarah' style='width:100%; padding:12px; background:#0f172a; border:1px solid #334155; border-radius:12px; color:white; margin-bottom:12px; outline:none;'/>

            <label style='display:block; font-size:0.8rem; font-weight:700; margin-bottom:4px;'>Target Band Score</label>
            <input type='text' id='new-partner-band-input' value='Band 7.5' style='width:100%; padding:12px; background:#0f172a; border:1px solid #334155; border-radius:12px; color:white; margin-bottom:18px; outline:none;'/>

            <div style='display:flex; gap:10px;'>
                <button onclick='closeAddPartnerModal()' style='flex:1; padding:12px; background:#334155; color:white; border:none; border-radius:12px; font-weight:700; cursor:pointer;'>Cancel</button>
                <button onclick='saveNewPartner()' style='flex:1; padding:12px; background:var(--primary-gradient); color:white; border:none; border-radius:12px; font-weight:800; cursor:pointer;'>Start Chatting</button>
            </div>
        </div>
    </div>

    <!-- SLIDE-UP IN-CALL CHAT SHEET -->
    <div class='chat-bottom-sheet' id='incall-chat-sheet'>
        <div style='display:flex; justify-content:space-between; align-items:center; padding-bottom:10px; border-bottom:1px solid var(--border);'>
            <h4 style='font-size:0.95rem; font-weight:800; color:#38bdf8;'><i class='fa-solid fa-comments'></i> Live In-Call Text Chat</h4>
            <button onclick='closeInCallChatSheet()' style='background:#334155; color:white; border:none; padding:4px 10px; border-radius:6px; cursor:pointer;'>Close</button>
        </div>
        <div class='chat-feed-box' id='incall-chat-feed'></div>
        <div style='display:flex; gap:8px; padding-top:10px;'>
            <input type='text' id='incall-msg-input' placeholder='Type a message to partner...' onkeydown='if(event.key==="Enter")sendInCallMessage()' style='flex:1; padding:10px 14px; background:#0f172a; border:1px solid #334155; border-radius:10px; color:white; outline:none;'/>
            <button onclick='sendInCallMessage()' style='padding:10px 16px; background:#0284c7; color:white; border:none; border-radius:10px; font-weight:700; cursor:pointer;'>Send</button>
        </div>
    </div>

    <!-- SIDEBAR DRAWER (YEAR SELECTOR FOR IN-CALL QUESTION CARDS) -->
    <div class='sidebar-drawer' id='incall-sidebar-drawer'>
        <div style='display:flex; justify-content:space-between; align-items:center; margin-bottom:16px;'>
            <h3 style='font-size:1.05rem; font-weight:800; color:#38bdf8;'>Select Exam Year:</h3>
            <button onclick='toggleSidebarDrawer()' style='background:#334155; color:white; border:none; width:30px; height:30px; border-radius:50%; cursor:pointer;' aria-label='Close Sidebar'>✕</button>
        </div>
        <div id='sidebar-years-list'></div>
    </div>

    <!-- TOAST POPUP -->
    <div class='toast-popup' id='global-toast'>Notification</div>

    <!-- BOTTOM NAVIGATION (INSTANT UNBLOCKED ACCESS) -->
    <nav class='bottom-nav'>
        <a class='nav-item active' id='nav-speaking' onclick="switchTab('speaking')">
            <i class='fa-solid fa-headset'></i>
            <span>Speaking</span>
        </a>
        <a class='nav-item' id='nav-writing' onclick="switchTab('writing')">
            <i class='fa-solid fa-pen-to-square'></i>
            <span>Writing</span>
        </a>
        <a class='nav-item' id='nav-call' onclick="switchTab('call')">
            <i class='fa-solid fa-phone-volume'></i>
            <span>Live Call</span>
        </a>
        <a class='nav-item' id='nav-chat' onclick="switchTab('chat')">
            <i class='fa-solid fa-comments'></i>
            <span>Direct Chat</span>
        </a>
        <a class='nav-item' id='nav-profile' onclick="switchTab('profile')">
            <i class='fa-solid fa-user'></i>
            <span>Profile</span>
        </a>
    </nav>

    <!-- HIDDEN AUDIO TAG FOR PEERJS AUDIO STREAM -->
    <audio id='remoteAudio' autoplay='autoplay'></audio>
"@

# Build Fast JS Engine with Top Loader & Instant Navigation
$jsEngine = @'

    /* -------------------------------------------------------------
       TOP PAGE LOADER ANIMATION CONTROLS
    ------------------------------------------------------------- */
    function showTopLoader() {
        const l = document.getElementById('top-page-loader');
        if (l) l.classList.add('active');
    }
    function hideTopLoader() {
        const l = document.getElementById('top-page-loader');
        if (l) l.classList.remove('active');
    }

    /* -------------------------------------------------------------
       INSTANT NAVIGATION: SWITCH TABS IMMEDIATELY & CANCEL WAITING
    ------------------------------------------------------------- */
    function cancelAllLoading() {
        hideTopLoader();
        try {
            window.stop();
        } catch(e) {}
        document.querySelectorAll('.img-skeleton').forEach(el => {
            el.style.animation = 'none';
            el.style.background = '#1e293b';
        });
        if (typeof stopRandomMatchmaking === 'function') {
            stopRandomMatchmaking();
        }
        const b = document.getElementById('cancel-load-btn');
        if (b) b.style.display = 'none';
        showToast("Loading stopped. Content is fully accessible!");
    }

    function switchTab(tabId) {
        hideTopLoader();
        const cancelBtn = document.getElementById('cancel-load-btn');
        if (cancelBtn) cancelBtn.style.display = 'none';

        document.querySelectorAll('.tab-content').forEach(el => el.style.display = 'none');
        document.querySelectorAll('.nav-item').forEach(el => el.classList.remove('active'));

        const targetTab = document.getElementById('tab-' + tabId);
        if (targetTab) targetTab.style.display = 'block';

        const navBtn = document.getElementById('nav-' + tabId);
        if (navBtn) navBtn.classList.add('active');

        window.scrollTo({ top: 0, behavior: 'instant' });

        const subtitles = {
            'speaking': 'Speaking Questions',
            'writing': 'Writing Tasks',
            'call': 'Live Random Match',
            'chat': 'Direct Messages',
            'profile': 'Candidate Profile'
        };
        const st = document.getElementById('header-subtitle');
        if (st) st.innerText = subtitles[tabId] || 'Cambridge Official';

        if (tabId === 'call') {
            initLottieCallAnimation();
            if (!activeMediaCall) {
                startRandomMatchmaking();
            }
        } else {
            // Cancel / stop searching if user navigates away from call screen
            if (isSearchingRandom && !activeMediaCall) {
                stopRandomMatchmaking();
            }
        }

        if (tabId === 'chat') {
            renderDirectContacts();
        }
    }

    function cancelMatchmaking() {
        stopRandomMatchmaking();
        hideTopLoader();
        document.getElementById('call-status-heading').innerText = "Search Cancelled";
        document.getElementById('call-partner-meta').innerText = "Tap Find Random Partner when ready to connect";
        showToast("Matchmaking cancelled");
    }

    /* -------------------------------------------------------------
       EMBEDDED LOTTIE ANIMATION DATA
    ------------------------------------------------------------- */
    const switchUserCardsData = @@LOTTIE_JSON@@;

    /* -------------------------------------------------------------
       USER PROFILE & STATE
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
       PERMANENT ID GENERATION & PERSISTENCE
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
        const elHeader = document.getElementById('header-my-id');
        if (elHeader) elHeader.innerText = id;
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
                text: `Join my live IELTS Speaking call using my Permanent ID: ${id}`,
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
        showToast("Permanent ID updated! Reconnecting WebRTC...");
        if (peerInstance) peerInstance.destroy();
        initWebRtcEngine();
    }

    /* -------------------------------------------------------------
       IMMEDIATE DOM INITIALIZATION (No blocking window.onload)
    ------------------------------------------------------------- */
    function initAppFast() {
        document.querySelectorAll('.staggered-img').forEach(function(img) {
            if (img.complete && img.naturalWidth > 0) {
                markLoaded(img);
            }
        });
        hideTopLoader();
        loadUserProfile();
        updateIdDisplays();
        renderDirectContacts();
        renderInCallSidebarYears();
        // Background WebRTC engine initialization
        setTimeout(initWebRtcEngine, 200);

        setTimeout(function() {
            var anyPending = document.querySelector('.img-skeleton:not([style*="none"])');
            if (anyPending) {
                var btn = document.getElementById('cancel-load-btn');
                if (btn) btn.style.display = 'inline-flex';
            }
        }, 1500);
    }

    /* -------------------------------------------------------------
       TAB 1: SPEAKING DETAIL VIEW
    ------------------------------------------------------------- */
    function openSpeakingYear(year) {
        showTopLoader();
        activeSpeakingYear = year;
        activeSpeakingSetIndex = 0;
        document.getElementById('speaking-grid-view').style.display = 'none';
        document.getElementById('speaking-detail-view').classList.add('active');
        document.getElementById('speaking-detail-header').innerText = `IELTS Speaking ${year}`;
        renderSpeakingSets();
        window.scrollTo({ top: 0, behavior: 'instant' });
        setTimeout(hideTopLoader, 150);
    }

    function closeSpeakingDetail() {
        document.getElementById('speaking-detail-view').classList.remove('active');
        document.getElementById('speaking-grid-view').style.display = 'block';
        window.scrollTo({ top: 0, behavior: 'instant' });
    }

    function renderSpeakingSets() {
        const paper = getSpeakingPaperData(activeSpeakingYear);
        const pillsContainer = document.getElementById('speaking-set-pills');
        pillsContainer.innerHTML = paper.sets.map((s, idx) => `
            <button class="set-pill ${idx === activeSpeakingSetIndex ? 'active' : ''}" onclick="selectSpeakingSet(${idx})">${s.setTitle}</button>
        `).join('');

        const currentSet = paper.sets[activeSpeakingSetIndex];
        const container = document.getElementById('speaking-questions-container');

        container.innerHTML = `
            <div style="margin-bottom:14px; padding:12px 16px; background:rgba(30,41,59,0.7); border:1px solid var(--border); border-radius:16px;">
                <div style="font-weight:800; font-size:1rem; color:#38bdf8;">${currentSet.topicTheme}</div>
            </div>
            ${currentSet.questions.map(q => `
                <div class="question-card">
                    <div class="question-card-header">
                        <span class="q-number-tag">${q.qLabel}</span>
                        <span class="part-label-tag">${q.partLabel}</span>
                    </div>
                    <div class="question-title">${q.title}</div>
                    <div class="prompt-box-inner">${q.prompt.replace(/\n/g, '<br/>')}</div>
                    ${q.bullets && q.bullets.length ? `
                        <ul class="bullet-points-box">
                            ${q.bullets.map(b => `<li>${b}</li>`).join('')}
                        </ul>
                    ` : ''}

                    <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:8px;">
                        <span style="font-size:0.85rem; font-weight:800; color:#38bdf8;">Ranked Model Answers (Band 9.0 – 5.0):</span>
                        <button class="btn-copy" onclick="copyTextToClipboard('${escapeJs(q.masterAnswer)}')"><i class="fa-regular fa-copy"></i> Copy</button>
                    </div>

                    <div class="band-score-tabs">
                        ${[9.0, 8.5, 8.0, 7.5, 7.0, 6.5, 6.0, 5.5, 5.0].map((b, i) => `
                            <button class="band-score-tab ${i === 0 ? 'active' : ''}" onclick="updateBandText(this, '${escapeJs(q.masterAnswer)}', ${b})">Band ${b.toFixed(1)}</button>
                        `).join('')}
                    </div>

                    <div class="answer-display-box">${q.masterAnswer}</div>

                    ${q.vocabulary && q.vocabulary.length ? `
                        <div class="vocab-chips-box">
                            ${q.vocabulary.map(v => `<span class="vocab-chip">${v}</span>`).join('')}
                        </div>
                    ` : ''}
                </div>
            `).join('')}
        `;
    }

    function selectSpeakingSet(idx) {
        activeSpeakingSetIndex = idx;
        renderSpeakingSets();
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
        document.getElementById('writing-detail-header').innerText = `IELTS Writing ${year}`;
        renderWritingSets();
        window.scrollTo({ top: 0, behavior: 'instant' });
        setTimeout(hideTopLoader, 150);
    }

    function closeWritingDetail() {
        document.getElementById('writing-detail-view').classList.remove('active');
        document.getElementById('writing-grid-view').style.display = 'block';
        window.scrollTo({ top: 0, behavior: 'instant' });
    }

    function renderWritingSets() {
        const paper = getWritingPaperData(activeWritingYear);
        const pillsContainer = document.getElementById('writing-set-pills');
        pillsContainer.innerHTML = paper.sets.map((s, idx) => `
            <button class="set-pill ${idx === activeWritingSetIndex ? 'active' : ''}" onclick="selectWritingSet(${idx})">${s.setTitle}</button>
        `).join('');

        const currentSet = paper.sets[activeWritingSetIndex];
        const container = document.getElementById('writing-questions-container');

        container.innerHTML = `
            <div style="margin-bottom:14px; padding:12px 16px; background:rgba(30,41,59,0.7); border:1px solid var(--border); border-radius:16px;">
                <div style="font-weight:800; font-size:1rem; color:#38bdf8;">${currentSet.topicTheme}</div>
            </div>
            ${currentSet.questions.map(q => `
                <div class="question-card">
                    <div class="question-card-header">
                        <span class="q-number-tag">${q.qLabel}</span>
                        <span class="part-label-tag">${q.taskTypeLabel}</span>
                    </div>
                    <div class="question-title">${q.topicTitle}</div>
                    <div class="prompt-box-inner">${q.prompt.replace(/\n/g, '<br/>')}</div>

                    <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:8px;">
                        <span style="font-size:0.85rem; font-weight:800; color:#38bdf8;">Ranked Model Answers (Band 9.0 – 5.0):</span>
                        <button class="btn-copy" onclick="copyTextToClipboard('${escapeJs(q.masterAnswer)}')"><i class="fa-regular fa-copy"></i> Copy</button>
                    </div>

                    <div class="band-score-tabs">
                        ${[9.0, 8.5, 8.0, 7.5, 7.0, 6.5, 6.0, 5.5, 5.0].map((b, i) => `
                            <button class="band-score-tab ${i === 0 ? 'active' : ''}" onclick="updateBandText(this, '${escapeJs(q.masterAnswer)}', ${b})">Band ${b.toFixed(1)}</button>
                        `).join('')}
                    </div>

                    <div class="answer-display-box">${q.masterAnswer}</div>
                </div>
            `).join('')}
        `;
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
        const parent = btnEl.closest('.question-card');
        parent.querySelectorAll('.band-score-tab').forEach(b => b.classList.remove('active'));
        btnEl.classList.add('active');

        const displayBox = parent.querySelector('.answer-display-box');
        if (band >= 8.5) {
            displayBox.innerText = masterAns;
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
        if (lottieAnimInstance) return;
        const container = document.getElementById('lottie-call-container');
        if (!container) return;
        if (typeof lottie === 'undefined') {
            setTimeout(initLottieCallAnimation, 300);
            return;
        }
        try {
            lottieAnimInstance = lottie.loadAnimation({
                container: container,
                renderer: 'svg',
                loop: true,
                autoplay: true,
                animationData: switchUserCardsData
            });
        } catch (e) {
            console.warn("Lottie render error:", e);
        }
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
            console.log("Web client subscribed to call chat topic:", activeCallChatTopic);
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
                console.log("Connected to HiveMQ MQTT broker! Subscribed to lobby & personal DM:", myId);
            });

            mqttClient.on('message', (topic, payload) => {
                const myId = getOrCreatePermanentId();

                // 1. IN-CALL LIVE CHAT MESSAGE (Dual delivery: WebRTC + MQTT)
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
                                    console.log("Match found! Calling partner:", msg.peerId);
                                    stopRandomMatchmaking();
                                    startOutgoingCallTo(msg.peerId, msg.name, msg.targetBand, msg.country);
                                }
                            }
                        }
                    } catch (e) {}
                    return;
                }

                // 3. TAB 4 DIRECT 1-ON-1 CHAT MESSAGE
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
                                bubble.className = 'msg-bubble received';
                                bubble.innerHTML = `
                                    <div class="msg-sender">${escapeHtml(senderName)}</div>
                                    <div>${escapeHtml(data.text)}</div>
                                    <div class="msg-time">${data.time}</div>
                                `;
                                feed.appendChild(bubble);
                                feed.scrollTop = feed.scrollHeight;
                            }
                        } else {
                            showToast(`New message from ${senderName}: ${data.text.substring(0, 28)}...`);
                        }
                        renderDirectContacts();
                    } catch(e) {
                        console.error("Direct msg receive error:", e);
                    }
                    return;
                }
            });
        } catch (err) {
            console.warn("MQTT lobby error:", err);
        }
    }

    function startRandomMatchmaking() {
        if (activeMediaCall) return;
        isSearchingRandom = true;
        showTopLoader();
        document.getElementById('call-status-heading').innerText = "Searching for practice partner...";
        document.getElementById('call-partner-meta').innerText = "Matching with online candidates...";
        document.getElementById('searching-controls-row').style.display = 'flex';
        document.getElementById('call-in-progress-controls').style.display = 'none';
        document.getElementById('call-timer-display').style.display = 'none';
        if (lottieAnimInstance) lottieAnimInstance.play();
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
            console.warn("Mic access error:", err);
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

            peerInstance.on('error', (err) => {
                console.warn("PeerJS error:", err);
            });

        } catch (err) {
            console.warn("PeerJS engine init error:", err);
        }
    }

    function toggleIdControls() {
        const panel = document.getElementById('id-controls-panel');
        panel.classList.toggle('open');
        document.getElementById('key-toggle-btn').classList.toggle('active', panel.classList.contains('open'));
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
            document.getElementById('id-controls-panel').classList.remove('open');
            document.getElementById('key-toggle-btn').classList.remove('active');
            document.getElementById('searching-controls-row').style.display = 'none';
            document.getElementById('call-in-progress-controls').style.display = 'flex';
            document.getElementById('call-timer-display').style.display = 'block';

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

                // If chat sheet is closed, show badge and notification
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

        // 1. Send via DataConnection if open
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

        // 2. Dual Send via MQTT Call Topic for 100% Guaranteed Delivery
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
        bubble.className = `msg-bubble ${isSent ? 'sent' : 'received'}`;
        bubble.innerHTML = `
            ${!isSent ? `<div class="msg-sender">${sender}</div>` : ''}
            <div>${escapeHtml(text)}</div>
            <div class="msg-time">${time}</div>
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
        document.getElementById('searching-controls-row').style.display = 'flex';
        document.getElementById('incall-carousel-section').classList.remove('active');
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
            showToast("Partner saved to Direct Practice Chats!");
            renderDirectContacts();
        } else {
            showToast("Partner is already in your Direct Chats!");
        }
    }

    /* -------------------------------------------------------------
       IN-CALL QUESTION CAROUSEL
    ------------------------------------------------------------- */
    function toggleSidebarDrawer() {
        document.getElementById('incall-sidebar-drawer').classList.toggle('open');
    }

    function renderInCallSidebarYears() {
        const list = document.getElementById('sidebar-years-list');
        list.innerHTML = allYears.map(yr => `
            <div class="sidebar-item" onclick="selectCallYearFromSidebar(${yr})">Year ${yr}</div>
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
        document.getElementById('incall-carousel-section').classList.add('active');
        renderCarouselCard();
    }

    function renderCarouselCard() {
        if (!carouselQuestionsList.length) return;
        const q = carouselQuestionsList[currentCarouselIndex];
        document.getElementById('carousel-year-title').innerText = `${carouselYear} (${currentCarouselIndex + 1}/${carouselQuestionsList.length}): ${q.title}`;
        document.getElementById('carousel-card-body').innerHTML = `
            <p style="font-weight:700; margin-bottom:8px; color:white;">${q.prompt.replace(/\n/g, '<br/>')}</p>
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
            <div class="contact-card" onclick="openDirectChat('${c.id}')">
                <div class="contact-avatar">${(c.name || 'P').charAt(0).toUpperCase()}</div>
                <div style="flex:1;">
                    <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:2px;">
                        <span style="font-weight:800; font-size:1rem; color:white;">${escapeHtml(c.name)}</span>
                        <span style="font-size:0.75rem; color:var(--text-muted);">${c.lastTime || ''}</span>
                    </div>
                    <div style="font-size:0.78rem; color:#38bdf8; font-weight:700; margin-bottom:4px;">ID: ${c.id} • ${c.targetBand || 'Band 7.5'}</div>
                    <div style="font-size:0.85rem; color:var(--text-muted); white-space:nowrap; overflow:hidden; text-overflow:ellipsis; max-width:260px;">${escapeHtml(c.lastMsg || 'Tap to chat')}</div>
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
            feed.innerHTML = `<div style="text-align:center; padding:30px; color:var(--text-muted); font-size:0.85rem;">No messages yet. Send a message to start practicing!</div>`;
        } else {
            messages.forEach(m => {
                const bubble = document.createElement('div');
                bubble.className = `msg-bubble ${m.isSent ? 'sent' : 'received'}`;
                bubble.innerHTML = `
                    ${!m.isSent ? `<div class="msg-sender">${escapeHtml(contact.name)}</div>` : ''}
                    <div>${escapeHtml(m.text)}</div>
                    <div class="msg-time">${m.time}</div>
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
        bubble.className = 'msg-bubble sent';
        bubble.innerHTML = `
            <div>${escapeHtml(txt)}</div>
            <div class="msg-time">${timeStr}</div>
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
            } catch(e) {
                console.error("Direct msg publish error:", e);
            }
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
       TAB 5: PROFILE
    ------------------------------------------------------------- */
    function setGender(g) {
        userProfile.gender = g;
        document.querySelectorAll('#gender-chips-container .set-pill').forEach(btn => {
            btn.classList.toggle('active', btn.innerText === g);
        });
    }

    function setTargetBand(b) {
        userProfile.targetBand = b;
        document.querySelectorAll('#band-chips-container .set-pill').forEach(btn => {
            btn.classList.toggle('active', btn.innerText === b);
        });
    }

    function saveCandidateProfile() {
        userProfile.name = document.getElementById('prof-name-input').value.trim() || 'Jhan Student';
        userProfile.age = document.getElementById('prof-age-input').value.trim() || '23';
        userProfile.country = document.getElementById('prof-country-input').value.trim() || 'Vietnam';

        localStorage.setItem('ielts_profile_config', JSON.stringify(userProfile));
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
                setGender(userProfile.gender || 'Male');
                setTargetBand(userProfile.targetBand || 'Band 7.5');
            } catch (e) {}
        }
    }

    /* -------------------------------------------------------------
       UTILITIES
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

    // Launch instantly on DOM ready without waiting for external images or scripts
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', initAppFast);
    } else {
        initAppFast();
    }
'@

# Replace the Lottie placeholder with real JSON
$fullJs = $cambridgeDataJs + "`n" + $jsEngine.Replace('@@LOTTIE_JSON@@', $lottieJson)

# ----------------- ASSEMBLE BLOGGER XML THEME -----------------
$finalXml = @"
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html b:css='false' b:responsive='true' xmlns='http://www.w3.org/1999/xhtml' xmlns:b='http://www.google.com/2005/gml/b' xmlns:data='http://www.google.com/2005/gml/data' xmlns:expr='http://www.google.com/2005/gml/expr'>
<head>
    <meta charset='utf-8'/>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no' name='viewport'/>
    <meta content='yes' name='apple-mobile-web-app-capable'/>
    <meta content='black-translucent' name='apple-mobile-web-app-status-bar-style'/>
    <meta content='IELTS Speaking &amp; Writing Prep Pro' name='apple-mobile-web-app-title'/>
    <meta content='telephone=no' name='format-detection'/>
    <title><data:blog.pageTitle/></title>

    <link href='https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;600;700;800&amp;display=swap' rel='stylesheet'/>
    <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css' rel='stylesheet'/>

    <!-- Deferred Non-Blocking Scripts: Instant First Contentful Paint -->
    <script src='https://unpkg.com/peerjs@1.5.4/dist/peerjs.min.js' defer='defer'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/lottie-web/5.12.2/lottie.min.js' defer='defer'></script>
    <script src='https://unpkg.com/mqtt@5.16.0/dist/mqtt.min.js' defer='defer'></script>

    <b:skin><![CDATA[
$fullCss
    ]]></b:skin>
</head>
<body>

    <!-- REQUIRED BLOGGER SECTION TO SATISFY XML PARSER -->
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

[System.IO.File]::WriteAllText($themeFile, $finalXml, [System.Text.Encoding]::UTF8)
Write-Host "Generated fast blogspot_theme.xml successfully! Size: " (Get-Item $themeFile).Length

# ----------------- ASSEMBLE STANDALONE HTML5 APP -----------------
$finalHtml = @"
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport"/>
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="black-translucent" name="apple-mobile-web-app-status-bar-style"/>
    <title>IELTS Speaking &amp; Writing Prep Pro (Cambridge Official Edition)</title>

    <link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;600;700;800&amp;display=swap" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet"/>

    <script src="https://unpkg.com/peerjs@1.5.4/dist/peerjs.min.js" defer="defer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lottie-web/5.12.2/lottie.min.js" defer="defer"></script>
    <script src="https://unpkg.com/mqtt@5.16.0/dist/mqtt.min.js" defer="defer"></script>

    <style>
$fullCss
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

[System.IO.File]::WriteAllText($htmlFile, $finalHtml, [System.Text.Encoding]::UTF8)
Write-Host "Generated fast blogspot_app.html successfully! Size: " (Get-Item $htmlFile).Length

# ----------------- VERIFY XML -----------------
$doc = New-Object System.Xml.XmlDocument
$doc.Load($themeFile)
Write-Host "XML VALIDATION SUCCESS! Root: " $doc.DocumentElement.Name
