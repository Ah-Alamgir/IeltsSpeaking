---
trigger: always_on
description: Project guidelines forbidding blogspot_app.html and enforcing single-source-of-truth in blogspot_theme.xml
---

# Project Guidelines: IELTS Speaking

## File Restrictions
- **Strictly DO NOT create `blogspot_app.html`** or any duplicate standalone HTML file.
- The web application is exclusively contained in `blogspot_theme.xml`. All web enhancements must be made directly to `blogspot_theme.xml`.
- On live call app start check for other available user and connect the user. Do not visible the id section as soon as the page loads. 


## Android & Assets
- Android native WebRTC logic is inside `app/src/main/assets/peer_call.html` and managed by `PeerJsCallManager.kt`.
- Do not add random test files or HTML files to the repository root.
