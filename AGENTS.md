# Project Rules & Guidelines for IELTS Speaking Practice

## 1. Web Deployment & Files
- **DO NOT create or regenerate `blogspot_app.html`** or any duplicate standalone HTML files in this project unless explicitly requested by the user.
- **Single Source of Truth for Web:** The Blogger web app is solely defined and maintained in `blogspot_theme.xml`. All web changes, styling, WebRTC logic, audio controls, and Cambridge dataset updates must be made directly to `blogspot_theme.xml`.
- When updating `blogspot_theme.xml`, ensure the file remains valid XML (all scripts inside `//<![CDATA[ ... //]]>`) and compatible with the Blogger Theme Editor.

## 2. Android App Architecture
- Android native calling relies on `app/src/main/assets/peer_call.html` loaded inside WebView by `com.ielts.speaking.call.PeerJsCallManager.kt`.
- UI is built using Jetpack Compose with Material 3.
- Always verify compilation using `./gradlew compileDebugKotlin` after making Kotlin or Android asset changes.

## 3. WebRTC & Audio Processing Rules
- Never route the incoming WebRTC remote audio stream through Web Audio API `AudioContext.createMediaStreamDestination()`. The raw stream must be attached directly to `<audio id="remoteAudio">.srcObject` to ensure native Acoustic Echo Cancellation (AEC) and Noise Suppression (NS) remain operational.
- Maintain the Opus SDP optimization hook (forcing mono, DTX, FEC, and 32kbps speech bitrate).
- Maintain the same-device loopback guard (`BroadcastChannel`) to prevent physical speaker-microphone acoustic feedback when testing multiple tabs on one computer.
