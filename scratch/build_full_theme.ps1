# Build complete blogspot_theme.xml and blogspot_app.html
$ErrorActionPreference = 'Stop'

$lottieJson = [System.IO.File]::ReadAllText('C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\switchusercards.json')

$themeFile = 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_theme.xml'
$htmlFile = 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_app.html'

# Load base content from blogspot_theme.xml
$existingXml = [System.IO.File]::ReadAllText($themeFile)

# Extract CSS from existing theme
$cssStart = $existingXml.IndexOf('<b:skin><![CDATA[') + 17
$cssEnd = $existingXml.IndexOf(']]></b:skin>')
$css = $existingXml.Substring($cssStart, $cssEnd - $cssStart)

# Extract Speaking & Writing Data Generator JS functions from existing theme
$jsDataStart = $existingXml.IndexOf('const allYears = Array.from')
$jsDataEnd = $existingXml.IndexOf('/* -------------------------------------------------------------`r`n       TAB 3: WEBRTC')
if ($jsDataEnd -lt 0) {
    $jsDataEnd = $existingXml.IndexOf('/* -------------------------------------------------------------`n       TAB 3: WEBRTC')
}
if ($jsDataEnd -lt 0) {
    $jsDataEnd = $existingXml.IndexOf('TAB 3: WEBRTC')
    $jsDataEnd = $existingXml.LastIndexOf('/*', $jsDataEnd)
}
$cambridgeDataJs = $existingXml.Substring($jsDataStart, $jsDataEnd - $jsDataStart)

# Additional CSS rules for empty state, modal, buttons, and lottie
$extraCss = @'

    /* Additional UI Styles */
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
        padding: 12px 20px;
        border-radius: 14px;
        font-weight: 800;
        font-size: 0.9rem;
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

$fullCss = $css + $extraCss

# Build Main Body HTML
$bodyHtml = @'
    <!-- MAIN APP HEADER -->
    <header class='app-header'>
        <div class='brand-title'>
            <i class='fa-solid fa-graduation-cap' style='color:#38bdf8;'></i>
            <span>IELTS Prep Pro</span>
            <span id='header-subtitle' style='font-size:0.75rem; font-weight:600; color:var(--text-muted); margin-left:4px;'>Cambridge Official</span>
        </div>
        <div class='header-actions'>
            <div class='my-id-pill' onclick='copyPermanentId()' title='Click to copy your Permanent Call ID'>
                <i class='fa-solid fa-id-badge'></i>
                <span id='header-my-id'>Loading...</span>
            </div>
            <button class='header-btn' id='key-toggle-btn' onclick='toggleIdControls()' aria-label='Toggle ID Controls' title='Enter Partner Call ID'>
                <i class='fa-solid fa-key'></i>
            </button>
        </div>
    </header>

    <!-- MAIN BODY CONTAINER -->
    <main class='app-main'>

        <!-- ========================================== -->
        <!-- TAB 1: SPEAKING (Staggered Grid -> 4 Sets) -->
        <!-- ========================================== -->
        <div id='tab-speaking' class='tab-content'>
            <div id='speaking-grid-view'>
                <div style='margin-bottom:14px;'>
                    <h2 style='font-size:1.15rem; font-weight:800; color:#38bdf8;'>Speaking Question Papers</h2>
                    <p style='font-size:0.82rem; color:var(--text-muted);'>Authentic Cambridge IELTS Tests (Years 2026 – 2001)</p>
                </div>
                <div class='staggered-grid' id='speaking-staggered-container'></div>
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
        <!-- TAB 2: WRITING (Staggered Grid -> 4 Sets)  -->
        <!-- ========================================== -->
        <div id='tab-writing' class='tab-content' style='display:none;'>
            <div id='writing-grid-view'>
                <div style='margin-bottom:14px;'>
                    <h2 style='font-size:1.15rem; font-weight:800; color:#38bdf8;'>Writing Tasks &amp; Essays</h2>
                    <p style='font-size:0.82rem; color:var(--text-muted);'>Official Cambridge Academic Task 1 &amp; Discursive Task 2</p>
                </div>
                <div class='staggered-grid' id='writing-staggered-container'></div>
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

                <!-- Searching Controls Row (Before Connected) -->
                <div id='searching-controls-row' style='display:flex; justify-content:center; gap:10px; margin-top:18px;'>
                    <button class='search-action-btn btn-search-random' onclick='startRandomMatchmaking()'>
                        <i class='fa-solid fa-rotate'></i> Find Random Partner
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
                    <div style='background:#0f172a; border:1px solid rgba(56,189,248,0.25); border-radius:10px; padding:10px 14px; font-family:monospace; font-weight:800; color:#38bdf8; font-size:0.95rem; margin-bottom:10px; word-break:break-all;' id='my-peer-id-text'>Initializing Permanent ID...</div>
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

    <!-- BOTTOM NAVIGATION -->
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
'@

Write-Host "Body HTML built successfully!"
