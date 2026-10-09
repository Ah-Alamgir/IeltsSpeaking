$ErrorActionPreference = 'Stop'

# Load files
$themeFile = 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_theme.xml'
$htmlFile = 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_app.html'

$lottieJson = [System.IO.File]::ReadAllText('C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\switchusercards.json')

# Run build_full_theme.ps1 to get variables
. .\scratch\build_full_theme.ps1

$jsEngine = @'

    /* -------------------------------------------------------------
       EMBEDDED LOTTIE ANIMATION DATA (Cards Switching)
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
       APP INITIALIZATION & NAVIGATION
    ------------------------------------------------------------- */
    function initApp() {
        loadUserProfile();
        updateIdDisplays();
        renderSpeakingGrid();
        renderWritingGrid();
        renderDirectContacts();
        renderInCallSidebarYears();
        initWebRtcEngine();
    }

    function switchTab(tabId) {
        document.querySelectorAll('.tab-content').forEach(el => el.style.display = 'none');
        document.querySelectorAll('.nav-item').forEach(el => el.classList.remove('active'));

        const targetTab = document.getElementById('tab-' + tabId);
        if (targetTab) targetTab.style.display = 'block';

        const navBtn = document.getElementById('nav-' + tabId);
        if (navBtn) navBtn.classList.add('active');

        // Subtitle & Header logic
        const subtitles = {
            'speaking': 'Speaking Questions',
            'writing': 'Writing Tasks',
            'call': 'Live Random Match',
            'chat': 'Direct Messages',
            'profile': 'Candidate Profile'
        };
        document.getElementById('header-subtitle').innerText = subtitles[tabId] || 'Cambridge Official';

        if (tabId === 'call') {
            initLottieCallAnimation();
            if (!activeMediaCall) {
                startRandomMatchmaking();
            }
        } else {
            // Pause searching if moving away from call screen
            if (isSearchingRandom && !activeMediaCall) {
                stopRandomMatchmaking();
            }
        }

        if (tabId === 'chat') {
            renderDirectContacts();
        }
    }

    /* -------------------------------------------------------------
       TAB 1: SPEAKING
    ------------------------------------------------------------- */
    function renderSpeakingGrid() {
        const container = document.getElementById('speaking-staggered-container');
        container.innerHTML = allYears.map((yr, idx) => {
            const h = staggeredHeights[idx % staggeredHeights.length];
            const img = speakingImages[idx % speakingImages.length];
            return `
                <div class="staggered-card" onclick="openSpeakingYear(${yr})">
                    <img src="${img}" alt="IELTS ${yr}" class="staggered-img" style="height:${h}px;" loading="lazy"/>
                    <div class="staggered-badge-box">
                        <span class="year-pill">${yr}</span>
                    </div>
                </div>
            `;
        }).join('');
    }

    function openSpeakingYear(year) {
        activeSpeakingYear = year;
        activeSpeakingSetIndex = 0;
        document.getElementById('speaking-grid-view').style.display = 'none';
        document.getElementById('speaking-detail-view').classList.add('active');
        document.getElementById('speaking-detail-header').innerText = `IELTS Speaking ${year}`;
        renderSpeakingSets();
    }

    function closeSpeakingDetail() {
        document.getElementById('speaking-detail-view').classList.remove('active');
        document.getElementById('speaking-grid-view').style.display = 'block';
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
       TAB 2: WRITING
    ------------------------------------------------------------- */
    function renderWritingGrid() {
        const container = document.getElementById('writing-staggered-container');
        container.innerHTML = allYears.map((yr, idx) => {
            const h = staggeredHeights[idx % staggeredHeights.length];
            const img = writingImages[idx % writingImages.length];
            return `
                <div class="staggered-card" onclick="openWritingYear(${yr})">
                    <img src="${img}" alt="Writing ${yr}" class="staggered-img" style="height:${h}px;" loading="lazy"/>
                    <div class="staggered-badge-box">
                        <span class="year-pill">${yr}</span>
                    </div>
                </div>
            `;
        }).join('');
    }

    function openWritingYear(year) {
        activeWritingYear = year;
        activeWritingSetIndex = 0;
        document.getElementById('writing-grid-view').style.display = 'none';
        document.getElementById('writing-detail-view').classList.add('active');
        document.getElementById('writing-detail-header').innerText = `IELTS Writing ${year}`;
        renderWritingSets();
    }

    function closeWritingDetail() {
        document.getElementById('writing-detail-view').classList.remove('active');
        document.getElementById('writing-grid-view').style.display = 'block';
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
        if (!container || typeof lottie === 'undefined') return;
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
    const MATCH_LOBBY_TOPIC = "ielts/speaking/match_lobby_v1";

    function initMqttMatchmaking() {
        try {
            if (typeof mqtt === 'undefined') return;
            mqttClient = mqtt.connect("wss://broker.hivemq.com:8884/mqtt", {
                clientId: 'ielts_web_' + Math.random().toString(16).substring(2, 8),
                clean: true,
                keepalive: 30
            });

            mqttClient.on('connect', () => {
                mqttClient.subscribe(MATCH_LOBBY_TOPIC);
                console.log("Connected to global matchmaking lobby!");
            });

            mqttClient.on('message', (topic, payload) => {
                if (topic !== MATCH_LOBBY_TOPIC || !isSearchingRandom || activeMediaCall) return;
                try {
                    const msg = JSON.parse(payload.toString());
                    const myId = getOrCreatePermanentId();
                    if (msg.type === 'WAITING' && msg.peerId && msg.peerId !== myId) {
                        const now = Date.now();
                        if (now - msg.timestamp < 12000) {
                            // Deterministic caller election: smaller ID calls larger ID
                            if (myId < msg.peerId) {
                                console.log("Match found! Calling partner:", msg.peerId);
                                stopRandomMatchmaking();
                                startOutgoingCallTo(msg.peerId, msg.name, msg.targetBand, msg.country);
                            }
                        }
                    }
                } catch (e) {}
            });
        } catch (err) {
            console.warn("MQTT lobby error:", err);
        }
    }

    function startRandomMatchmaking() {
        if (activeMediaCall) return;
        isSearchingRandom = true;
        document.getElementById('call-status-heading').innerText = "Searching for practice partner...";
        document.getElementById('call-partner-meta').innerText = "Looking for online candidates...";
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

    async function initWebRtcEngine() {
        try {
            localStream = await navigator.mediaDevices.getUserMedia({ audio: true, video: false });
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

            peerInstance.on('call', (call) => {
                stopRandomMatchmaking();
                activePartnerId = call.peer;
                activePartnerName = "Partner (" + call.peer.slice(-4) + ")";
                activeMediaCall = call;
                call.answer(localStream);
                bindMediaCallStreams(call);
            });

            peerInstance.on('connection', (conn) => {
                bindDataConnection(conn);
            });

            peerInstance.on('error', (err) => {
                console.warn("PeerJS error:", err);
            });

        } catch (err) {
            document.getElementById('call-status-heading').innerText = "Microphone Permission Required";
            console.warn("Mic access error:", err);
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

    function startOutgoingCallTo(targetId, name, band, country) {
        if (!peerInstance || !localStream) return alert("WebRTC engine not ready. Check mic access.");
        stopRandomMatchmaking();

        activePartnerId = targetId;
        activePartnerName = name || ("Partner (" + targetId.slice(-4) + ")");
        activePartnerBand = band || "Band 7.5";
        activePartnerCountry = country || "Global";

        document.getElementById('call-status-heading').innerText = "Connecting with partner...";
        document.getElementById('call-partner-meta').innerText = `${activePartnerName} (${activePartnerBand})`;

        const call = peerInstance.call(targetId, localStream);
        activeMediaCall = call;
        bindMediaCallStreams(call);

        const conn = peerInstance.connect(targetId);
        bindDataConnection(conn);
    }

    function bindMediaCallStreams(call) {
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

        appendChatMessageToFeed(senderName, txt, timeStr, true);
        input.value = '';

        if (activeDataConn && activeDataConn.open) {
            activeDataConn.send({
                type: 'CHAT_MSG',
                sender: senderName,
                text: txt,
                time: timeStr
            });
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
        const newMsg = {
            sender: "Me",
            text: txt,
            time: timeStr,
            isSent: true
        };

        saveChatMessage(activeDirectContact.id, newMsg);

        const feed = document.getElementById('direct-chat-feed');
        // If feed only had placeholder, clear it
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

    window.onload = initApp;
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

    <!-- PeerJS WebRTC Library for Free Audio Calling & DataChannel Messaging -->
    <script src='https://unpkg.com/peerjs@1.5.4/dist/peerjs.min.js'></script>
    <!-- Lottie Web Player for Animations -->
    <script src='https://cdnjs.cloudflare.com/ajax/libs/lottie-web/5.12.2/lottie.min.js'></script>
    <!-- MQTT WebSocket Client for Global Random Matchmaking -->
    <script src='https://unpkg.com/mqtt@5.16.0/dist/mqtt.min.js'></script>

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
Write-Host "Generated blogspot_theme.xml successfully! Size: " (Get-Item $themeFile).Length

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

    <script src="https://unpkg.com/peerjs@1.5.4/dist/peerjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lottie-web/5.12.2/lottie.min.js"></script>
    <script src="https://unpkg.com/mqtt@5.16.0/dist/mqtt.min.js"></script>

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
Write-Host "Generated blogspot_app.html successfully! Size: " (Get-Item $htmlFile).Length

# ----------------- VERIFY XML -----------------
$doc = New-Object System.Xml.XmlDocument
$doc.Load($themeFile)
Write-Host "XML VALIDATION SUCCESS! Root: " $doc.DocumentElement.Name
