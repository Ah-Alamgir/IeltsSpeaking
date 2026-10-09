package com.ielts.speaking.call

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioAttributes
import android.media.AudioDeviceInfo
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.webkit.*
import androidx.webkit.WebViewAssetLoader
import com.ielts.speaking.data.repository.ChatStorageManager
import com.ielts.speaking.ui.chat.DirectMessage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONObject

enum class CallState {
    IDLE,
    INITIALIZING,
    READY_TO_CALL,
    SEARCHING,
    CALLING,
    CONNECTED,
    DISCONNECTED,
    ERROR
}

data class CallUiState(
    val callState: CallState = CallState.IDLE,
    val myPeerId: String? = null,
    val partnerPeerId: String? = null,
    val isMuted: Boolean = false,
    val isSpeakerOn: Boolean = true,
    val statusMessage: String = "Connecting to audio network...",
    val durationSeconds: Int = 0,
    val isSearching: Boolean = false,
    val activeCandidatesCount: Int = 0
)

class PeerJsCallManager(private val context: Context) {

    private var webView: WebView? = null
    private val mainHandler = Handler(Looper.getMainLooper())
    private val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private var audioFocusRequest: AudioFocusRequest? = null

    private val _uiState = MutableStateFlow(CallUiState())
    val uiState: StateFlow<CallUiState> = _uiState.asStateFlow()

    private var timerHandler: Handler? = null
    private var timerRunnable: Runnable? = null
    private var isPageLoaded = false
    private val pendingJsQueue = mutableListOf<String>()

    private val assetLoader = WebViewAssetLoader.Builder()
        .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(context))
        .build()

    var onInCallMessageReceived: ((sender: String, text: String, time: String) -> Unit)? = null
    var onDirectMessageReceived: ((senderId: String, senderName: String, text: String, time: String) -> Unit)? = null

    @SuppressLint("SetJavaScriptEnabled")
    fun initializeWebView(onWebViewCreated: ((WebView) -> Unit)? = null): WebView {
        webView?.let { existing ->
            onWebViewCreated?.invoke(existing)
            return existing
        }

        val wv = WebView(context).apply {
            settings.javaScriptEnabled = true
            settings.mediaPlaybackRequiresUserGesture = false
            settings.domStorageEnabled = true
            settings.allowFileAccess = true

            webChromeClient = object : WebChromeClient() {
                override fun onPermissionRequest(request: PermissionRequest) {
                    mainHandler.post {
                        request.grant(request.resources)
                    }
                }
            }

            webViewClient = object : WebViewClient() {
                override fun shouldInterceptRequest(
                    view: WebView?,
                    request: WebResourceRequest?
                ): WebResourceResponse? {
                    val uri = request?.url ?: return null
                    return assetLoader.shouldInterceptRequest(uri)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    isPageLoaded = true
                    android.util.Log.d("PeerJsCallManager", "onPageFinished for $url. Pending scripts: ${pendingJsQueue.size}")
                    
                    val queued = pendingJsQueue.toList()
                    pendingJsQueue.clear()
                    queued.forEach { script ->
                        android.util.Log.d("PeerJsCallManager", "Flushing queued script: $script")
                        view?.evaluateJavascript(script, null)
                    }

                    if (_uiState.value.callState == CallState.IDLE) {
                        val permanentId = ChatStorageManager.getPermanentUserId(context)
                        startPeerEngine(permanentId)
                    }
                }
            }

            addJavascriptInterface(object {
                @JavascriptInterface
                fun onCallEvent(event: String, jsonPayload: String) {
                    mainHandler.post {
                        handleJsEvent(event, jsonPayload)
                    }
                }
            }, "AndroidBridge")

            loadUrl("https://appassets.androidplatform.net/assets/peer_call.html")
        }

        this.webView = wv
        onWebViewCreated?.invoke(wv)
        return wv
    }

    fun prewarm(customPeerId: String? = null) {
        mainHandler.post {
            initializeWebView {
                val targetId = customPeerId ?: ChatStorageManager.getPermanentUserId(context)
                if (isPageLoaded) {
                    startPeerEngine(targetId)
                } else {
                    startPeerEngine(targetId) // This will now be safely queued in pendingJsQueue
                }
            }
        }
    }

    fun startPeerEngine(customPeerId: String? = null) {
        val targetId = if (!customPeerId.isNullOrBlank()) customPeerId else ChatStorageManager.getPermanentUserId(context)
        _uiState.value = _uiState.value.copy(
            callState = CallState.INITIALIZING,
            statusMessage = "Connecting to WebRTC Peer Server with permanent ID...",
            myPeerId = targetId
        )
        evaluateJs("initPeer('$targetId');")
    }

    fun enterCallPage() {
        _uiState.value = _uiState.value.copy(
            callState = CallState.SEARCHING,
            isSearching = true,
            statusMessage = "Searching for random IELTS partner..."
        )
        evaluateJs("enterCallPage();")
    }

    fun leaveCallPage() {
        if (_uiState.value.callState != CallState.CONNECTED) {
            _uiState.value = _uiState.value.copy(
                callState = CallState.READY_TO_CALL,
                isSearching = false,
                activeCandidatesCount = 0,
                statusMessage = "Ready to connect"
            )
        }
        evaluateJs("leaveCallPage();")
    }

    fun startRandomMatchmaking() {
        enterCallPage()
    }

    fun stopRandomMatchmaking() {
        leaveCallPage()
    }

    fun nextRandomPartner() {
        hangup()
        mainHandler.postDelayed({
            enterCallPage()
        }, 250)
    }

    fun callPartner(targetPeerId: String) {
        activateCallAudio()
        _uiState.value = _uiState.value.copy(
            callState = CallState.CALLING,
            partnerPeerId = targetPeerId,
            statusMessage = "Connecting to $targetPeerId...",
            isSearching = false
        )
        evaluateJs("callPeer('$targetPeerId');")
    }

    fun toggleMute() {
        val newMuteState = !_uiState.value.isMuted
        _uiState.value = _uiState.value.copy(isMuted = newMuteState)
        evaluateJs("toggleMute($newMuteState);")
    }

    fun toggleSpeaker() {
        val newSpeakerState = !_uiState.value.isSpeakerOn
        _uiState.value = _uiState.value.copy(isSpeakerOn = newSpeakerState)
        applySpeakerState(newSpeakerState)
    }

    private fun applySpeakerState(enableSpeaker: Boolean) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                if (enableSpeaker) {
                    val speakerDevice = audioManager.availableCommunicationDevices.firstOrNull {
                        it.type == AudioDeviceInfo.TYPE_BUILTIN_SPEAKER
                    }
                    if (speakerDevice != null) {
                        audioManager.setCommunicationDevice(speakerDevice)
                    } else {
                        @Suppress("DEPRECATION")
                        audioManager.isSpeakerphoneOn = true
                    }
                } else {
                    val earpieceDevice = audioManager.availableCommunicationDevices.firstOrNull {
                        it.type == AudioDeviceInfo.TYPE_BUILTIN_EARPIECE
                    }
                    if (earpieceDevice != null) {
                        audioManager.setCommunicationDevice(earpieceDevice)
                    } else {
                        audioManager.clearCommunicationDevice()
                        @Suppress("DEPRECATION")
                        audioManager.isSpeakerphoneOn = false
                    }
                }
            } else {
                @Suppress("DEPRECATION")
                audioManager.isSpeakerphoneOn = enableSpeaker
            }
            android.util.Log.d("PeerJsCallManager", "Speaker state applied: enableSpeaker=$enableSpeaker")
        } catch (e: Exception) {
            android.util.Log.e("PeerJsCallManager", "Error applying speaker state: ${e.message}")
            try {
                @Suppress("DEPRECATION")
                audioManager.isSpeakerphoneOn = enableSpeaker
            } catch (_: Exception) {}
        }
    }

    private fun activateCallAudio() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_VOICE_COMMUNICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                    .build()
                val request = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                    .setAudioAttributes(audioAttributes)
                    .setAcceptsDelayedFocusGain(false)
                    .setOnAudioFocusChangeListener { /* Focus changes handled gracefully */ }
                    .build()
                audioFocusRequest = request
                audioManager.requestAudioFocus(request)
            } else {
                @Suppress("DEPRECATION")
                audioManager.requestAudioFocus(
                    null,
                    AudioManager.STREAM_VOICE_CALL,
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT
                )
            }

            audioManager.mode = AudioManager.MODE_IN_COMMUNICATION
            applySpeakerState(_uiState.value.isSpeakerOn)
            android.util.Log.d("PeerJsCallManager", "Voice Communication mode activated: hardware AEC & NS enabled.")
        } catch (e: Exception) {
            android.util.Log.e("PeerJsCallManager", "Failed to activate call audio: ${e.message}")
        }
    }

    private fun deactivateCallAudio() {
        try {
            audioManager.mode = AudioManager.MODE_NORMAL
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                audioManager.clearCommunicationDevice()
            }
            @Suppress("DEPRECATION")
            audioManager.isSpeakerphoneOn = false

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                audioFocusRequest?.let { audioManager.abandonAudioFocusRequest(it) }
                audioFocusRequest = null
            } else {
                @Suppress("DEPRECATION")
                audioManager.abandonAudioFocus(null)
            }
            android.util.Log.d("PeerJsCallManager", "Call audio deactivated: restored MODE_NORMAL.")
        } catch (e: Exception) {
            android.util.Log.e("PeerJsCallManager", "Failed to deactivate call audio: ${e.message}")
        }
    }

    fun hangup() {
        stopTimer()
        deactivateCallAudio()
        evaluateJs("hangup();")
        _uiState.value = _uiState.value.copy(
            callState = CallState.READY_TO_CALL,
            partnerPeerId = null,
            statusMessage = "Call ended. Ready for next session.",
            durationSeconds = 0,
            isSearching = false
        )
    }

    fun destroy() {
        hangup()
        deactivateCallAudio()
        mainHandler.post {
            try {
                webView?.destroy()
                webView = null
            } catch (e: Exception) {
                android.util.Log.e("PeerJsCallManager", "Error destroying webView: ${e.message}")
            }
        }
    }

    fun sendInCallChatMessage(senderName: String, text: String, time: String) {
        val escapedText = text.replace("'", "\\'").replace("\n", "\\n")
        val escapedSender = senderName.replace("'", "\\'")
        evaluateJs("sendInCallMsg('$escapedSender', '$escapedText', '$time');")
    }

    fun sendDirectDm(targetPeerId: String, text: String, time: String, senderName: String, band: String = "Band 7.5+", country: String = "Global") {
        val escapedText = text.replace("'", "\\'").replace("\n", "\\n")
        val escapedSender = senderName.replace("'", "\\'")
        evaluateJs("sendDirectDm('$targetPeerId', '$escapedText', '$time', '$escapedSender', '$band', '$country');")
    }

    private fun handleJsEvent(event: String, jsonPayload: String) {
        val json = try { JSONObject(jsonPayload) } catch (e: Exception) { JSONObject() }
        when (event) {
            "ON_OPEN" -> {
                val id = json.optString("peerId")
                _uiState.value = _uiState.value.copy(
                    callState = CallState.READY_TO_CALL,
                    myPeerId = id,
                    statusMessage = "Online! Ready to connect. Permanent ID: $id"
                )
            }
            "ON_CONNECTED" -> {
                val partner = json.optString("peerId")
                startTimer()
                activateCallAudio()
                _uiState.value = _uiState.value.copy(
                    callState = CallState.CONNECTED,
                    partnerPeerId = partner,
                    statusMessage = "Connected with Practice Partner",
                    isSearching = false
                )
            }
            "ON_DISCONNECTED", "ON_CLOSE" -> {
                stopTimer()
                deactivateCallAudio()
                _uiState.value = _uiState.value.copy(
                    callState = CallState.READY_TO_CALL,
                    partnerPeerId = null,
                    statusMessage = "Call ended",
                    durationSeconds = 0,
                    isSearching = false
                )
            }
            "ON_ERROR" -> {
                val err = json.optString("error", "Connection error")
                if (_uiState.value.callState != CallState.CONNECTED) {
                    deactivateCallAudio()
                    _uiState.value = _uiState.value.copy(
                        callState = CallState.ERROR,
                        statusMessage = "Notice: $err"
                    )
                }
            }
            "ON_CANDIDATE_COUNT" -> {
                val count = json.optInt("count", 0)
                _uiState.value = _uiState.value.copy(
                    activeCandidatesCount = count
                )
            }
            "ON_CHAT_MESSAGE" -> {
                val sender = json.optString("sender", "Partner")
                val text = json.optString("text", "")
                val time = json.optString("time", "Now")
                val partnerId = _uiState.value.partnerPeerId
                if (!partnerId.isNullOrBlank() && text.isNotBlank()) {
                    ChatStorageManager.saveMessage(
                        context,
                        partnerId!!,
                        DirectMessage(
                            sender = sender,
                            text = text,
                            timestamp = time
                        )
                    )
                }
                onInCallMessageReceived?.invoke(sender, text, time)
            }
            "ON_DIRECT_MESSAGE" -> {
                val senderId = json.optString("senderId")
                val senderName = json.optString("senderName", "Partner")
                val text = json.optString("text", "")
                val time = json.optString("time", "Now")
                if (senderId.isNotBlank() && text.isNotBlank()) {
                    ChatStorageManager.saveMessage(
                        context,
                        senderId,
                        DirectMessage(
                            sender = senderName,
                            text = text,
                            timestamp = time
                        )
                    )
                    onDirectMessageReceived?.invoke(senderId, senderName, text, time)
                }
            }
        }
    }

    private fun evaluateJs(script: String) {
        mainHandler.post {
            if (!isPageLoaded) {
                android.util.Log.d("PeerJsCallManager", "Page not loaded yet, queuing script: $script")
                pendingJsQueue.add(script)
            } else {
                android.util.Log.d("PeerJsCallManager", "Evaluating script: $script")
                webView?.evaluateJavascript(script, null)
            }
        }
    }

    private fun startTimer() {
        stopTimer()
        timerHandler = Handler(Looper.getMainLooper())
        timerRunnable = object : Runnable {
            override fun run() {
                _uiState.value = _uiState.value.copy(
                    durationSeconds = _uiState.value.durationSeconds + 1
                )
                timerHandler?.postDelayed(this, 1000)
            }
        }
        timerHandler?.postDelayed(timerRunnable!!, 1000)
    }

    private fun stopTimer() {
        timerRunnable?.let { timerHandler?.removeCallbacks(it) }
        timerHandler = null
        timerRunnable = null
    }

    private fun String?.isNullOrBlank(): Boolean {
        return this == null || (this.trim().isEmpty())
    }
}
