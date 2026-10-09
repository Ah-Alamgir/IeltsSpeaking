# Generate complete blogspot_theme.xml and blogspot_app.html
$lottieJson = [System.IO.File]::ReadAllText('C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\switchusercards.json')

$themePath = 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_theme.xml'
$appPath = 'C:\Users\abuha\AndroidStudioProjects\IeltsSpeaking\blogspot_app.html'

# Build CSS
$css = @'
    /* -------------------------------------------------------------
       RESET & HIDE BLOGGER DEFAULT OVERHEAD
    ------------------------------------------------------------- */
    .navbar, #navbar, #navbar-iframe, .widget-item-control, .item-control,
    .quickedit, .Attribution, #Attribution1, .blog-feeds, .post-feeds,
    .header-widget, .blog-pager, #blog-pager, .status-msg-wrap {
        display: none !important;
        visibility: hidden !important;
        height: 0 !important;
        margin: 0 !important;
        padding: 0 !important;
        border: none !important;
    }
    body#layout { display: none !important; }

    :root {
        --primary: #38bdf8;
        --primary-dark: #0284c7;
        --primary-glow: rgba(56, 189, 248, 0.35);
        --primary-gradient: linear-gradient(135deg, #0284c7, #6366f1);
        --accent-gradient: linear-gradient(135deg, #4f46e5, #0ea5e9);
        --emerald-gradient: linear-gradient(135deg, #059669, #0284c7);
        --card-gradient: linear-gradient(145deg, rgba(30, 41, 59, 0.85), rgba(15, 23, 42, 0.95));
        --bg: #090d16;
        --surface: #1e293b;
        --surface-variant: #334155;
        --text-main: #f8fafc;
        --text-muted: #94a3b8;
        --border: rgba(255, 255, 255, 0.08);
        --border-active: rgba(56, 189, 248, 0.45);
        --success: #10b981;
        --danger: #ef4444;
        --shadow: 0 10px 30px -5px rgba(0, 0, 0, 0.6);
    }

    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        font-family: 'Plus Jakarta Sans', -apple-system, BlinkMacSystemFont, sans-serif;
        -webkit-tap-highlight-color: transparent;
    }

    body {
        background-color: var(--bg);
        color: var(--text-main);
        display: flex;
        flex-direction: column;
        min-height: 100vh;
        overflow-x: hidden;
    }

    /* Top App Bar */
    header.app-header {
        background: rgba(15, 23, 42, 0.85);
        backdrop-filter: blur(20px);
        -webkit-backdrop-filter: blur(20px);
        padding: 12px 18px;
        border-bottom: 1px solid var(--border);
        display: flex;
        justify-content: space-between;
        align-items: center;
        position: sticky;
        top: 0;
        z-index: 100;
    }

    .brand-title {
        font-size: 1.15rem;
        font-weight: 800;
        background: var(--primary-gradient);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
        display: flex;
        align-items: center;
        gap: 10px;
        letter-spacing: -0.02em;
    }

    .header-actions {
        display: flex;
        align-items: center;
        gap: 8px;
    }

    .header-btn {
        background: rgba(255, 255, 255, 0.06);
        border: 1px solid var(--border);
        color: var(--text-main);
        width: 38px;
        height: 38px;
        border-radius: 12px;
        display: flex;
        align-items: center;
        justify-content: center;
        cursor: pointer;
        transition: all 0.2s ease;
    }
    .header-btn:hover {
        background: rgba(56, 189, 248, 0.15);
        border-color: var(--primary);
    }
    .header-btn.active {
        background: var(--primary-dark);
        color: white;
        border-color: var(--primary);
    }

    .my-id-pill {
        background: rgba(56, 189, 248, 0.12);
        border: 1px solid rgba(56, 189, 248, 0.3);
        color: #38bdf8;
        font-size: 0.78rem;
        font-weight: 800;
        font-family: monospace;
        padding: 6px 10px;
        border-radius: 10px;
        display: flex;
        align-items: center;
        gap: 6px;
        cursor: pointer;
    }

    /* Main Container */
    main.app-main {
        flex: 1;
        max-width: 900px;
        width: 100%;
        margin: 0 auto;
        padding: 16px 16px 90px 16px;
    }

    /* Staggered 3-Column Grid */
    .staggered-grid {
        column-count: 3;
        column-gap: 12px;
        width: 100%;
    }
    @media (max-width: 680px) {
        .staggered-grid { column-count: 2; column-gap: 10px; }
    }
    @media (max-width: 380px) {
        .staggered-grid { column-count: 1; }
    }

    .staggered-card {
        break-inside: avoid;
        margin-bottom: 12px;
        border-radius: 20px;
        overflow: hidden;
        position: relative;
        background: #1e293b;
        border: 1px solid var(--border);
        box-shadow: 0 4px 18px rgba(0, 0, 0, 0.4);
        cursor: pointer;
        transition: transform 0.25s cubic-bezier(0.34, 1.56, 0.64, 1), border-color 0.25s ease;
    }
    .staggered-card:hover {
        transform: translateY(-4px);
        border-color: var(--border-active);
    }

    .staggered-img {
        width: 100%;
        object-fit: cover;
        display: block;
        filter: brightness(0.92);
        transition: filter 0.3s ease;
    }
    .staggered-card:hover .staggered-img {
        filter: brightness(1.05);
    }

    .staggered-badge-box {
        position: absolute;
        top: 10px;
        left: 10px;
        right: 10px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        pointer-events: none;
    }

    .year-pill {
        background: rgba(15, 23, 42, 0.85);
        backdrop-filter: blur(10px);
        -webkit-backdrop-filter: blur(10px);
        border: 1px solid rgba(255, 255, 255, 0.15);
        color: white;
        font-weight: 800;
        font-size: 0.82rem;
        padding: 4px 10px;
        border-radius: 12px;
        letter-spacing: 0.02em;
    }

    /* Detail View for 4-Set Question Paper */
    .detail-view {
        display: none;
        animation: fadeIn 0.25s ease forwards;
    }
    .detail-view.active {
        display: block;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(6px); }
        to { opacity: 1; transform: translateY(0); }
    }

    .detail-header-card {
        background: var(--card-gradient);
        border: 1px solid var(--border);
        border-radius: 20px;
        padding: 16px;
        margin-bottom: 16px;
        display: flex;
        align-items: center;
        gap: 14px;
    }

    .back-btn {
        background: rgba(255, 255, 255, 0.08);
        border: 1px solid var(--border);
        color: white;
        width: 40px;
        height: 40px;
        border-radius: 12px;
        display: flex;
        align-items: center;
        justify-content: center;
        cursor: pointer;
        transition: background 0.2s ease;
    }
    .back-btn:hover {
        background: rgba(56, 189, 248, 0.2);
    }

    /* 4-Set Selector Pills */
    .set-pills-row {
        display: flex;
        gap: 8px;
        overflow-x: auto;
        padding-bottom: 10px;
        margin-bottom: 16px;
        scrollbar-width: none;
    }
    .set-pills-row::-webkit-scrollbar { display: none; }

    .set-pill {
        flex: 1;
        min-width: 90px;
        padding: 10px 14px;
        border-radius: 14px;
        font-size: 0.82rem;
        font-weight: 700;
        background: #1e293b;
        color: var(--text-muted);
        border: 1px solid var(--border);
        cursor: pointer;
        text-align: center;
        transition: all 0.2s ease;
        white-space: nowrap;
    }
    .set-pill.active {
        background: var(--primary-gradient);
        color: white;
        border-color: transparent;
        box-shadow: 0 4px 14px var(--primary-glow);
    }

    /* Question Card */
    .question-card {
        background: var(--card-gradient);
        border: 1px solid var(--border);
        border-radius: 20px;
        padding: 18px;
        margin-bottom: 16px;
        box-shadow: var(--shadow);
    }

    .question-card-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 10px;
    }

    .part-label-tag {
        font-size: 0.72rem;
        font-weight: 800;
        padding: 4px 8px;
        border-radius: 8px;
        text-transform: uppercase;
        background: rgba(56, 189, 248, 0.15);
        color: var(--primary);
    }

    .q-number-tag {
        font-size: 0.72rem;
        font-weight: 800;
        color: var(--text-muted);
    }

    .question-title {
        font-size: 1.05rem;
        font-weight: 800;
        color: white;
        margin-bottom: 8px;
        line-height: 1.35;
    }

    .prompt-box-inner {
        background: rgba(15, 23, 42, 0.6);
        border: 1px solid rgba(255, 255, 255, 0.05);
        border-radius: 14px;
        padding: 12px 14px;
        margin-bottom: 12px;
        font-size: 0.9rem;
        line-height: 1.5;
        color: #cbd5e1;
    }

    .bullet-points-box {
        margin: 10px 0;
        padding-left: 18px;
        font-size: 0.88rem;
        color: #94a3b8;
        line-height: 1.5;
    }
    .bullet-points-box li { margin-bottom: 4px; }

    /* Band Score Selector Tabs */
    .band-score-tabs {
        display: flex;
        gap: 6px;
        overflow-x: auto;
        padding: 4px 0 10px 0;
        margin-bottom: 10px;
        scrollbar-width: none;
    }
    .band-score-tabs::-webkit-scrollbar { display: none; }

    .band-score-tab {
        background: #0f172a;
        color: var(--text-muted);
        border: 1px solid var(--border);
        border-radius: 8px;
        padding: 6px 10px;
        font-size: 0.75rem;
        font-weight: 800;
        cursor: pointer;
        white-space: nowrap;
        transition: all 0.2s;
    }
    .band-score-tab.active {
        background: #0284c7;
        color: white;
        border-color: #38bdf8;
    }

    .answer-display-box {
        background: #0f172a;
        border: 1px solid var(--border);
        border-radius: 12px;
        padding: 14px;
        font-size: 0.9rem;
        line-height: 1.6;
        color: #e2e8f0;
        position: relative;
    }

    .vocab-chips-box {
        display: flex;
        flex-wrap: wrap;
        gap: 6px;
        margin-top: 10px;
    }

    .vocab-chip {
        background: rgba(99, 102, 241, 0.15);
        border: 1px solid rgba(99, 102, 241, 0.3);
        color: #a5b4fc;
        font-size: 0.72rem;
        font-weight: 700;
        padding: 4px 8px;
        border-radius: 8px;
    }

    .btn-copy {
        background: rgba(255, 255, 255, 0.08);
        border: 1px solid var(--border);
        color: white;
        padding: 6px 12px;
        border-radius: 8px;
        font-size: 0.75rem;
        font-weight: 700;
        cursor: pointer;
        display: inline-flex;
        align-items: center;
        gap: 6px;
        transition: background 0.2s;
    }
    .btn-copy:hover {
        background: var(--primary-dark);
    }

    /* Live Call View */
    .call-view-card {
        background: var(--card-gradient);
        border: 1px solid var(--border);
        border-radius: 28px;
        padding: 30px 20px;
        text-align: center;
        box-shadow: var(--shadow);
        position: relative;
        overflow: hidden;
    }

    .call-duration {
        font-size: 1.8rem;
        font-weight: 800;
        color: #38bdf8;
        margin: 10px 0;
        font-family: monospace;
    }

    .id-controls-card {
        background: rgba(15, 23, 42, 0.9);
        border: 1px solid var(--border);
        border-radius: 18px;
        padding: 16px;
        margin-top: 18px;
        text-align: left;
        display: none;
    }
    .id-controls-card.open { display: block; }

    .call-actions-row {
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 16px;
        margin-top: 24px;
        flex-wrap: wrap;
    }

    .btn-circle {
        width: 58px;
        height: 58px;
        border-radius: 50%;
        border: none;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 1.3rem;
        cursor: pointer;
        transition: transform 0.2s, background-color 0.2s;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.4);
    }
    .btn-circle:hover { transform: scale(1.08); }

    .btn-mute-call { background: var(--surface-variant); color: white; }
    .btn-mute-call.muted { background: var(--danger); }
    .btn-chat-call { background: #4f46e5; color: white; position: relative; }
    .btn-skip-call { background: #0284c7; color: white; }
    .btn-hangup-call { background: var(--danger); color: white; }

    .unread-badge {
        position: absolute;
        top: -3px;
        right: -3px;
        width: 14px;
        height: 14px;
        background: #ef4444;
        border: 2px solid #0f172a;
        border-radius: 50%;
        display: none;
    }

    /* In-Call Question Slide Carousel */
    .carousel-section {
        background: #1e293b;
        border: 1px solid var(--border);
        border-radius: 20px;
        padding: 16px;
        margin-top: 20px;
        text-align: left;
        display: none;
    }
    .carousel-section.active { display: block; }

    /* In-Call Chat Slide-up Sheet */
    .chat-bottom-sheet {
        position: fixed;
        bottom: 72px;
        left: 0;
        right: 0;
        max-width: 900px;
        margin: 0 auto;
        background: rgba(15, 23, 42, 0.98);
        border: 1px solid var(--border-active);
        border-radius: 24px 24px 0 0;
        padding: 16px;
        height: 380px;
        display: flex;
        flex-direction: column;
        z-index: 95;
        transform: translateY(110%);
        transition: transform 0.3s cubic-bezier(0.16, 1, 0.3, 1);
        box-shadow: 0 -10px 40px rgba(0,0,0,0.8);
    }
    .chat-bottom-sheet.open {
        transform: translateY(0);
    }

    .chat-feed-box {
        flex: 1;
        overflow-y: auto;
        padding: 10px 0;
        display: flex;
        flex-direction: column;
        gap: 8px;
    }

    .msg-bubble {
        max-width: 80%;
        padding: 10px 14px;
        border-radius: 16px;
        font-size: 0.88rem;
        line-height: 1.4;
        word-break: break-word;
    }
    .msg-bubble.sent {
        align-self: flex-end;
        background: #0284c7;
        color: white;
        border-bottom-right-radius: 4px;
    }
    .msg-bubble.received {
        align-self: flex-start;
        background: #334155;
        color: #f1f5f9;
        border-bottom-left-radius: 4px;
    }
    .msg-sender {
        font-size: 0.72rem;
        font-weight: 800;
        color: #38bdf8;
        margin-bottom: 2px;
    }
    .msg-time {
        font-size: 0.65rem;
        opacity: 0.7;
        text-align: right;
        margin-top: 4px;
    }

    /* Contacts List & Direct Chat */
    .contact-card {
        background: var(--card-gradient);
        border: 1px solid var(--border);
        border-radius: 18px;
        padding: 14px;
        margin-bottom: 10px;
        display: flex;
        align-items: center;
        gap: 14px;
        cursor: pointer;
        transition: border-color 0.2s;
    }
    .contact-card:hover {
        border-color: var(--primary);
    }

    .contact-avatar {
        width: 48px;
        height: 48px;
        border-radius: 50%;
        background: var(--accent-gradient);
        display: flex;
        align-items: center;
        justify-content: center;
        font-weight: 800;
        color: white;
        font-size: 1.1rem;
        position: relative;
    }

    .online-indicator {
        position: absolute;
        bottom: 0;
        right: 0;
        width: 12px;
        height: 12px;
        border-radius: 50%;
        background: #10b981;
        border: 2px solid #0f172a;
    }

    .direct-chat-window {
        display: none;
        background: var(--card-gradient);
        border: 1px solid var(--border);
        border-radius: 24px;
        padding: 16px;
        height: 520px;
        flex-direction: column;
    }
    .direct-chat-window.active { display: flex; }

    /* Empty State Box */
    .empty-state-box {
        text-align: center;
        padding: 40px 20px;
        color: var(--text-muted);
    }
    .empty-state-icon {
        width: 70px;
        height: 70px;
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
        max-width: 420px;
        width: 100%;
        box-shadow: var(--shadow);
    }

    /* Bottom Navigation Bar */
    nav.bottom-nav {
        position: fixed;
        bottom: 10px;
        left: 14px;
        right: 14px;
        max-width: 580px;
        margin: 0 auto;
        background: rgba(30, 41, 59, 0.95);
        backdrop-filter: blur(25px);
        -webkit-backdrop-filter: blur(25px);
        border: 1px solid rgba(255, 255, 255, 0.12);
        border-radius: 35px;
        padding: 8px 14px;
        display: flex;
        justify-content: space-around;
        box-shadow: 0 10px 35px rgba(0, 0, 0, 0.7);
        z-index: 100;
    }

    .nav-item {
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 3px;
        color: var(--text-muted);
        text-decoration: none;
        font-size: 0.7rem;
        font-weight: 700;
        cursor: pointer;
        padding: 4px 10px;
        border-radius: 18px;
        transition: all 0.2s ease;
    }
    .nav-item i { font-size: 1.15rem; }
    .nav-item.active {
        color: var(--primary);
        transform: translateY(-2px);
    }

    /* Sidebar Drawer */
    .sidebar-drawer {
        position: fixed;
        top: 0;
        right: -300px;
        width: 280px;
        height: 100vh;
        background: #0f172a;
        border-left: 1px solid var(--border);
        box-shadow: -10px 0 30px rgba(0, 0, 0, 0.8);
        padding: 20px 16px;
        overflow-y: auto;
        transition: right 0.3s cubic-bezier(0.16, 1, 0.3, 1);
        z-index: 150;
    }
    .sidebar-drawer.open { right: 0; }

    .sidebar-item {
        padding: 12px 14px;
        background: #1e293b;
        border: 1px solid var(--border);
        border-radius: 12px;
        color: white;
        font-weight: 700;
        margin-bottom: 8px;
        cursor: pointer;
        transition: all 0.2s;
    }
    .sidebar-item:hover {
        background: #0284c7;
        border-color: #38bdf8;
    }

    /* Toast Notification */
    .toast-popup {
        position: fixed;
        top: 68px;
        left: 50%;
        transform: translateX(-50%);
        background: #0284c7;
        color: white;
        padding: 10px 22px;
        border-radius: 30px;
        font-weight: 700;
        font-size: 0.85rem;
        box-shadow: 0 10px 25px rgba(2, 132, 199, 0.5);
        display: none;
        z-index: 300;
    }
'@

Write-Host "CSS Prepared. Length: " $css.Length
