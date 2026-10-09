package com.ielts.speaking

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.ielts.speaking.call.PeerJsCallManager
import com.ielts.speaking.ui.navigation.AppNavigation
import com.ielts.speaking.ui.theme.IeltsSpeakingTheme

class MainActivity : ComponentActivity() {

    private lateinit var callManager: PeerJsCallManager

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        // Microphone permission granted for WebRTC PeerJS audio call
        val audioGranted = permissions[Manifest.permission.RECORD_AUDIO] == true
        if (audioGranted) {
            callManager.startPeerEngine()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        callManager = PeerJsCallManager(this)
        callManager.prewarm()
        checkAndRequestPermissions()

        setContent {
            IeltsSpeakingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        // Hidden persistent WebView hosting the WebRTC PeerJS engine across all navigation tabs
                        Box(modifier = Modifier.size(1.dp)) {
                            AndroidView(
                                factory = { _ ->
                                    callManager.initializeWebView().also { wv ->
                                        (wv.parent as? android.view.ViewGroup)?.removeView(wv)
                                    }
                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        AppNavigation(callManager = callManager)
                    }
                }
            }
        }
    }

    private fun checkAndRequestPermissions() {
        val permissionsToRequest = mutableListOf<String>()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            permissionsToRequest.add(Manifest.permission.RECORD_AUDIO)
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.MODIFY_AUDIO_SETTINGS) != PackageManager.PERMISSION_GRANTED) {
            permissionsToRequest.add(Manifest.permission.MODIFY_AUDIO_SETTINGS)
        }

        if (permissionsToRequest.isNotEmpty()) {
            requestPermissionLauncher.launch(permissionsToRequest.toTypedArray())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        callManager.destroy()
    }
}
