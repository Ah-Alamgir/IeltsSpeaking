package com.ielts.speaking.ui.call

import android.content.Intent
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ielts.speaking.call.CallState
import com.ielts.speaking.call.PeerJsCallManager
import com.ielts.speaking.data.model.SpeakingQuestionItem
import com.ielts.speaking.data.model.SpeakingTestSet
import com.ielts.speaking.data.repository.ChatStorageManager
import com.ielts.speaking.data.repository.IeltsRepository
import com.ielts.speaking.data.repository.SpeakingDataProvider
import com.ielts.speaking.ui.chat.ChatContact
import com.ielts.speaking.ui.chat.DirectMessage
import com.ielts.speaking.ui.speaking.Part2CueCardView
import com.ielts.speaking.ui.speaking.PartQuestionCardView
import com.ielts.speaking.ui.util.Band9HighlightUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AudioCallScreen(
    callManager: PeerJsCallManager,
    onNavigateToMessages: (partnerId: String?) -> Unit = {}
) {
    val callUiState by callManager.uiState.collectAsState()

    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    var partnerInputId by remember { mutableStateOf("") }
    var selectedYearForCall by remember { mutableIntStateOf(2026) }
    var selectedSetIndex by remember { mutableIntStateOf(0) }
    var isSidebarOpen by remember { mutableStateOf(false) }
    var isCallInfoHidden by remember { mutableStateOf(false) }
    var showYearPicker by remember { mutableStateOf(false) }
    var showSetPicker by remember { mutableStateOf(false) }

    // Auto-search for partner when opening Live Call screen, cleanup when leaving
    DisposableEffect(Unit) {
        if (callUiState.callState != CallState.CONNECTED && callUiState.callState != CallState.CALLING) {
            callManager.enterCallPage()
        }
        onDispose {
            if (callUiState.callState != CallState.CONNECTED) {
                callManager.leaveCallPage()
            }
        }
    }

    // Listen to incoming in-call messages from WebRTC DataConnection
    // Store directly in ChatStorageManager for Messages scene (Tab 4)
    DisposableEffect(callManager, callUiState.partnerPeerId) {
        callManager.onInCallMessageReceived = { sender, text, time ->
            val partnerId = callUiState.partnerPeerId ?: "partner"
            val timestamp = if (time.isNotBlank()) time else SimpleDateFormat("h:mm a", Locale.getDefault()).format(Date())
            ChatStorageManager.saveMessage(
                context,
                partnerId,
                DirectMessage(sender = sender, text = text, timestamp = timestamp)
            )
            Toast.makeText(context, "New message from $sender: \"$text\"", Toast.LENGTH_SHORT).show()
        }
        onDispose {
            callManager.onInCallMessageReceived = null
        }
    }

    Scaffold(
        topBar = {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left: Close / Leave
                    IconButton(
                        onClick = {
                            if (callUiState.callState == CallState.CONNECTED) {
                                callManager.hangup()
                            } else if (callUiState.isSearching) {
                                callManager.stopRandomMatchmaking()
                            }
                        },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Leave Room",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    // Center: Cambridge Session Tag
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = if (callUiState.callState == CallState.CONNECTED) Color(0xFF10B981) else Color(0xFFF7A827),
                                modifier = Modifier.size(6.dp)
                            ) {}
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (callUiState.callState == CallState.CONNECTED) "Connected • Live Drill"
                                       else if (callUiState.isSearching) "Searching Partner..."
                                       else "Cambridge Audio Match",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }

                    // Right: Actions
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // Black-marked button (Tune) exclusively on Live Call tab:
                        // Toggles hiding/unhiding call details and reveals speaking question set
                        IconButton(
                            onClick = { isCallInfoHidden = !isCallInfoHidden },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Tune,
                                contentDescription = "Toggle Call Details / Question Sets",
                                tint = if (isCallInfoHidden) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        // Cue Cards Sidebar Icon
                        IconButton(
                            onClick = { isSidebarOpen = !isSidebarOpen },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.AutoStories,
                                contentDescription = "Cue Cards Sidebar",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                if (isCallInfoHidden) {
                    // Mode: Call details hidden, full speaking question sets visible
                    if (callUiState.callState == CallState.CONNECTED) {
                        ConnectedPeerStage(
                            partnerId = callUiState.partnerPeerId ?: "Peer Partner",
                            durationSeconds = callUiState.durationSeconds,
                            onSaveContact = {
                                val pid = callUiState.partnerPeerId ?: return@ConnectedPeerStage
                                ChatStorageManager.saveContact(
                                    context,
                                    ChatContact(
                                        id = pid,
                                        name = "Partner (${pid.takeLast(4)})",
                                        targetBand = "Band 7.5+"
                                    )
                                )
                                Toast.makeText(context, "Saved partner ID to Messages scene!", Toast.LENGTH_SHORT).show()
                            },
                            onOpenChat = {
                                val pid = callUiState.partnerPeerId
                                if (!pid.isNullOrBlank()) {
                                    ChatStorageManager.saveContact(
                                        context,
                                        ChatContact(
                                            id = pid,
                                            name = "Partner (${pid.takeLast(4)})",
                                            targetBand = "Band 7.5+"
                                        )
                                    )
                                }
                                onNavigateToMessages(callUiState.partnerPeerId)
                            }
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                    } else {
                        // Compact background searching status badge
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f),
                            modifier = Modifier.padding(bottom = 6.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Sync,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.secondary,
                                    modifier = Modifier.size(13.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = if (callUiState.activeCandidatesCount > 0)
                                        "Searching • ${callUiState.activeCandidatesCount} candidate${if (callUiState.activeCandidatesCount > 1) "s" else ""} on page"
                                    else
                                        "Searching for speaking partners...",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }
                        }
                    }

                    // Speaking question set from Speaking tab:
                    // Single row with Select Year & Select Question Set, and questions with Band 9 answers!
                    LiveCallQuestionBrowser(
                        selectedYear = selectedYearForCall,
                        selectedSetIndex = selectedSetIndex,
                        onOpenYearPicker = { showYearPicker = true },
                        onOpenSetPicker = { showSetPicker = true },
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(vertical = 4.dp)
                    )
                } else {
                    // Standard view: black-marked call details visible
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .then(if (callUiState.callState == CallState.CONNECTED) Modifier.wrapContentHeight() else Modifier.weight(1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (callUiState.callState == CallState.CONNECTED) {
                            ConnectedPeerStage(
                                partnerId = callUiState.partnerPeerId ?: "Peer Partner",
                                durationSeconds = callUiState.durationSeconds,
                                onSaveContact = {
                                    val pid = callUiState.partnerPeerId ?: return@ConnectedPeerStage
                                    ChatStorageManager.saveContact(
                                        context,
                                        ChatContact(
                                            id = pid,
                                            name = "Partner (${pid.takeLast(4)})",
                                            targetBand = "Band 7.5+"
                                        )
                                    )
                                    Toast.makeText(context, "Saved partner ID to Messages scene!", Toast.LENGTH_SHORT).show()
                                },
                                onOpenChat = {
                                    val pid = callUiState.partnerPeerId
                                    if (!pid.isNullOrBlank()) {
                                        ChatStorageManager.saveContact(
                                            context,
                                            ChatContact(
                                                id = pid,
                                                name = "Partner (${pid.takeLast(4)})",
                                                targetBand = "Band 7.5+"
                                            )
                                        )
                                    }
                                    onNavigateToMessages(callUiState.partnerPeerId)
                                }
                            )
                        } else {
                            // Matchmaking Stage: Sonar / Radar
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                StitchSonarRadarAnimation()

                                Spacer(modifier = Modifier.height(18.dp))

                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f)
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Sync,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.secondary,
                                            modifier = Modifier.size(13.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = "Connecting peers...",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.secondary
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Searching for Speaking Partners",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = MaterialTheme.colorScheme.primary
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = "Matching by Target Band 7.0 – 8.5 & Cambridge Cue Cards",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Surface(
                                        shape = CircleShape,
                                        color = Color(0xFF10B981),
                                        modifier = Modifier.size(6.dp)
                                    ) {}
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (callUiState.activeCandidatesCount > 0)
                                            "${callUiState.activeCandidatesCount} candidate${if (callUiState.activeCandidatesCount > 1) "s" else ""} currently on this page"
                                        else
                                            "Searching for partners on this page...",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }

                    // Middle Area when not hidden:
                    if (callUiState.callState == CallState.CONNECTED) {
                        LiveCallQuestionBrowser(
                            selectedYear = selectedYearForCall,
                            selectedSetIndex = selectedSetIndex,
                            onOpenYearPicker = { showYearPicker = true },
                            onOpenSetPicker = { showSetPicker = true },
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(vertical = 4.dp)
                        )
                    } else {
                        // Permanent ID section
                        val displayId = callUiState.myPeerId ?: ChatStorageManager.getPermanentUserId(context)
                        PermanentIdCard(
                            myPeerId = displayId,
                            partnerInputId = partnerInputId,
                            onPartnerInputChanged = { partnerInputId = it },
                            onCopyId = {
                                val id = callUiState.myPeerId ?: ""
                                clipboardManager.setText(AnnotatedString(id))
                                Toast.makeText(context, "Permanent Call ID copied!", Toast.LENGTH_SHORT).show()
                            },
                            onShareId = {
                                val id = callUiState.myPeerId ?: ""
                                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                    type = "text/plain"
                                    putExtra(
                                        Intent.EXTRA_TEXT,
                                        "Let's practice IELTS Speaking! Join my audio call using my Permanent Peer ID: $id"
                                    )
                                }
                                context.startActivity(Intent.createChooser(shareIntent, "Share Speaking ID"))
                            },
                            onDirectDial = {
                                val target = partnerInputId.trim()
                                if (target.isNotBlank()) {
                                    Toast.makeText(context, "Dialing partner ID: $target...", Toast.LENGTH_SHORT).show()
                                    callManager.callPartner(target)
                                }
                            }
                        )
                    }
                }

                // Floating Bottom Call Controls Pill
                Surface(
                    shape = RoundedCornerShape(32.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f)),
                    shadowElevation = 6.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 6.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Mic Mute Button
                        IconButton(
                            onClick = { callManager.toggleMute() },
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(if (callUiState.isMuted) Color(0xFFBA1A1A) else MaterialTheme.colorScheme.primary)
                        ) {
                            Icon(
                                imageVector = if (callUiState.isMuted) Icons.Default.MicOff else Icons.Default.Mic,
                                contentDescription = "Mute",
                                tint = Color.White,
                                modifier = Modifier.size(22.dp)
                            )
                        }

                        // Speaker Button (Toggles between Loudspeaker and Earpiece)
                        IconButton(
                            onClick = {
                                callManager.toggleSpeaker()
                                val nextMode = if (!callUiState.isSpeakerOn) "Loudspeaker" else "Earpiece"
                                Toast.makeText(context, "$nextMode enabled", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(if (callUiState.isSpeakerOn) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface)
                        ) {
                            Icon(
                                imageVector = if (callUiState.isSpeakerOn) Icons.Default.VolumeUp else Icons.Default.PhoneInTalk,
                                contentDescription = if (callUiState.isSpeakerOn) "Switch to Earpiece" else "Switch to Loudspeaker",
                                tint = if (callUiState.isSpeakerOn) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        // Next Peer Button
                        Button(
                            onClick = {
                                callManager.nextRandomPartner()
                                Toast.makeText(context, "Searching next partner...", Toast.LENGTH_SHORT).show()
                            },
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.SkipNext,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Next Peer",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        // Messages Button (Navigates directly to Messages scene)
                        IconButton(
                            onClick = {
                                val pid = callUiState.partnerPeerId
                                if (!pid.isNullOrBlank()) {
                                    ChatStorageManager.saveContact(
                                        context,
                                        ChatContact(
                                            id = pid,
                                            name = "Partner (${pid.takeLast(4)})",
                                            targetBand = "Band 7.5+"
                                        )
                                    )
                                }
                                onNavigateToMessages(callUiState.partnerPeerId)
                            },
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.surface)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Message,
                                contentDescription = "Direct Messages",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        // End Call Button (Crimson Minimal #BA1A1A)
                        IconButton(
                            onClick = { callManager.hangup() },
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFBA1A1A))
                        ) {
                            Icon(
                                imageVector = Icons.Default.CallEnd,
                                contentDescription = "End Call",
                                tint = Color.White,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                }
            }

            // Questions Sidebar Overlay (Does not resize or squash main call stage)
            if (isSidebarOpen) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f))
                        .clickable { isSidebarOpen = false }
                )
            }

            AnimatedVisibility(
                visible = isSidebarOpen,
                enter = slideInHorizontally(initialOffsetX = { it }) + fadeIn(),
                exit = slideOutHorizontally(targetOffsetX = { it }) + fadeOut(),
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                CueCardsSidebarOverlay(
                    selectedYear = selectedYearForCall,
                    selectedSetIndex = selectedSetIndex,
                    onSelect = { yr, sIdx ->
                        selectedYearForCall = yr
                        selectedSetIndex = sIdx
                        isSidebarOpen = false
                    },
                    onClose = { isSidebarOpen = false }
                )
            }

            if (showYearPicker) {
                val years = remember { IeltsRepository.years }
                val yearItems = remember(years) {
                    years.map { yr ->
                        CallPickerItem(
                            title = "$yr",
                            subtitle = "Cambridge ${getCambridgeBookNum(yr)}"
                        )
                    }
                }
                val currentIndex = years.indexOf(selectedYearForCall).coerceAtLeast(0)
                BirthdayStylePickerDialog(
                    title = "Select Year",
                    items = yearItems,
                    selectedIndex = currentIndex,
                    onItemSelected = { idx ->
                        selectedYearForCall = years[idx]
                        selectedSetIndex = 0
                        showYearPicker = false
                    },
                    onDismissRequest = { showYearPicker = false }
                )
            }

            if (showSetPicker) {
                val paper = remember(selectedYearForCall) { IeltsRepository.getSpeakingPaper(selectedYearForCall) }
                val setItems = remember(paper) {
                    paper.sets.map { s ->
                        CallPickerItem(
                            title = s.setTitle,
                            subtitle = s.topicTheme
                        )
                    }
                }
                BirthdayStylePickerDialog(
                    title = "Select Question Set",
                    items = setItems,
                    selectedIndex = selectedSetIndex.coerceIn(0, (setItems.size - 1).coerceAtLeast(0)),
                    onItemSelected = { idx ->
                        selectedSetIndex = idx
                        showSetPicker = false
                    },
                    onDismissRequest = { showSetPicker = false }
                )
            }
        }
    }
}

fun getCambridgeBookNum(year: Int): String {
    return when {
        year >= 2025 -> "20"
        year >= 2024 -> "19"
        year >= 2023 -> "18"
        year >= 2022 -> "17"
        year >= 2021 -> "16"
        year >= 2020 -> "15"
        year >= 2019 -> "14"
        year >= 2018 -> "13"
        year >= 2017 -> "12"
        year >= 2016 -> "11"
        year >= 2015 -> "10"
        else -> maxOf(1, year - 2005).toString()
    }
}

data class CallPickerItem(
    val title: String,
    val subtitle: String? = null
)

@Composable
fun BirthdayStylePickerDialog(
    title: String,
    items: List<CallPickerItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    onDismissRequest: () -> Unit
) {
    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = (selectedIndex - 2).coerceAtLeast(0)
    )

    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {},
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary
                )
                IconButton(
                    onClick = onDismissRequest,
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 320.dp)
                        .padding(vertical = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    itemsIndexed(items) { index, item ->
                        val isSelected = index == selectedIndex
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .clickable { onItemSelected(index) },
                            color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 14.dp, vertical = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = item.title,
                                        fontSize = 14.sp,
                                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium,
                                        color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                                    )
                                    if (!item.subtitle.isNullOrBlank()) {
                                        Text(
                                            text = item.subtitle,
                                            fontSize = 11.sp,
                                            color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f) else MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                                if (isSelected) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "Selected",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
            }
        },
        shape = RoundedCornerShape(20.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp
    )
}

@Composable
fun LiveCallQuestionBrowser(
    selectedYear: Int,
    selectedSetIndex: Int,
    onOpenYearPicker: () -> Unit,
    onOpenSetPicker: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current
    val paper = remember(selectedYear) { IeltsRepository.getSpeakingPaper(selectedYear) }
    val currentSet = paper.sets.getOrElse(selectedSetIndex) { paper.sets.first() }

    Column(modifier = modifier) {
        // Single Row Selector: Select Year & Select Question Set
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Select Year Button
            Surface(
                modifier = Modifier
                    .weight(0.44f)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onOpenYearPicker() },
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f))
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "SELECT YEAR",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$selectedYear (Cam ${getCambridgeBookNum(selectedYear)})",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            // Select Question Set Button
            Surface(
                modifier = Modifier
                    .weight(0.56f)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onOpenSetPicker() },
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f))
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "SELECT QUESTION SET",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = currentSet.setTitle,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }

        // Topic Theme Banner
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
            border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "Topic: ${currentSet.topicTheme}",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
            )
        }

        // Scrollable Questions and Model Answers
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(currentSet.questions) { q ->
                if (q.qNumber == 2) {
                    Part2CueCardView(
                        question = q,
                        onCopyAnswer = {
                            clipboardManager.setText(AnnotatedString(q.band9Answer))
                            Toast.makeText(context, "Band 9 Answer copied to clipboard!", Toast.LENGTH_SHORT).show()
                        }
                    )
                } else {
                    PartQuestionCardView(
                        question = q,
                        onCopyAnswer = {
                            clipboardManager.setText(AnnotatedString(q.band9Answer))
                            Toast.makeText(context, "Band 9 Answer copied to clipboard!", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CueCardsSidebarOverlay(
    selectedYear: Int,
    selectedSetIndex: Int,
    onSelect: (year: Int, setIndex: Int) -> Unit,
    onClose: () -> Unit
) {
    val years = remember { listOf(2026, 2025, 2024, 2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016) }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        shadowElevation = 16.dp,
        tonalElevation = 8.dp
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(14.dp)) {
            // Sidebar Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(
                        imageVector = Icons.Default.AutoStories,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Cambridge Cue Cards",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(
                    onClick = onClose,
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(Icons.Default.Close, contentDescription = "Close", modifier = Modifier.size(18.dp))
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Select a test to drill questions & Band 9 model answers during the call:",
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(years) { yr ->
                    val isCurrentYear = selectedYear == yr
                    val paper = SpeakingDataProvider.getSpeakingPaper(yr)
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isCurrentYear) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
                        ),
                        border = BorderStroke(
                            1.dp,
                            if (isCurrentYear) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                        )
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "Cambridge $yr",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            paper.sets.forEachIndexed { sIdx, s ->
                                val isSelected = isCurrentYear && selectedSetIndex == sIdx
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                                    border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 2.dp)
                                        .clickable { onSelect(yr, sIdx) }
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "${s.setTitle}: ${s.topicTheme}",
                                            fontSize = 10.sp,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                            modifier = Modifier.weight(1f)
                                        )
                                        Icon(
                                            imageVector = Icons.Default.ChevronRight,
                                            contentDescription = null,
                                            tint = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                            modifier = Modifier.size(14.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PermanentIdCard(
    myPeerId: String,
    partnerInputId: String,
    onPartnerInputChanged: (String) -> Unit,
    onCopyId: () -> Unit,
    onShareId: () -> Unit,
    onDirectDial: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your Permanent IELTS ID:",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "Permanent",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = myPeerId,
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onCopyId,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(15.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Copy ID", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                    onClick = onShareId,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(15.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Share", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Dial partner directly
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = partnerInputId,
                    onValueChange = onPartnerInputChanged,
                    placeholder = { Text("Dial Partner's Permanent ID...", fontSize = 11.sp) },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Button(
                    onClick = onDirectDial,
                    enabled = partnerInputId.isNotBlank(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.Call, contentDescription = null, modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@Composable
fun ConnectedPeerStage(
    partnerId: String,
    durationSeconds: Int,
    onSaveContact: () -> Unit,
    onOpenChat: () -> Unit
) {
    val mins = durationSeconds / 60
    val secs = durationSeconds % 60
    val formattedTime = String.format(Locale.getDefault(), "%02d:%02d", mins, secs)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Peer Avatar Disc with Online Ring
        Box(contentAlignment = Alignment.Center) {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surfaceVariant,
                border = BorderStroke(3.dp, MaterialTheme.colorScheme.secondary),
                modifier = Modifier.size(76.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(42.dp)
                    )
                }
            }

            Surface(
                shape = CircleShape,
                color = Color(0xFF10B981),
                border = BorderStroke(2.dp, Color.White),
                modifier = Modifier
                    .size(15.dp)
                    .align(Alignment.BottomEnd)
            ) {}
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sarah M. (Practice Partner)",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Peer ID: $partnerId • Target Band 7.5+",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Timer
        Text(
            text = formattedTime,
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Dynamic Waveform bars
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(24.dp)
        ) {
            val infiniteTransition = rememberInfiniteTransition(label = "waveform")
            val barHeights = listOf(10.dp, 18.dp, 8.dp, 22.dp, 14.dp, 20.dp, 10.dp, 16.dp)
            barHeights.forEachIndexed { i, baseH ->
                val animatedScale by infiniteTransition.animateFloat(
                    initialValue = 0.4f,
                    targetValue = 1.0f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(400 + i * 100, easing = FastOutSlowInEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "barScale$i"
                )
                Surface(
                    shape = RoundedCornerShape(2.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .width(4.dp)
                        .height(baseH * animatedScale)
                ) {}
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // In-Call Action Buttons Row: Send Message & Save Partner
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = onOpenChat,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.AutoMirrored.Filled.Message, contentDescription = null, modifier = Modifier.size(15.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Send Message", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
            OutlinedButton(
                onClick = onSaveContact,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Default.BookmarkAdd, contentDescription = null, modifier = Modifier.size(15.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Save Partner", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun StitchSonarRadarAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "stitch_radar")
    val pulse1 by infiniteTransition.animateFloat(
        initialValue = 0.85f,
        targetValue = 1.75f,
        animationSpec = infiniteRepeatable(
            animation = tween(2800, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "pulse1"
    )
    val alpha1 by infiniteTransition.animateFloat(
        initialValue = 0.65f,
        targetValue = 0.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(2800, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "alpha1"
    )

    val pulse2 by infiniteTransition.animateFloat(
        initialValue = 0.85f,
        targetValue = 1.55f,
        animationSpec = infiniteRepeatable(
            animation = tween(2800, delayMillis = 900, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "pulse2"
    )
    val alpha2 by infiniteTransition.animateFloat(
        initialValue = 0.55f,
        targetValue = 0.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(2800, delayMillis = 900, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "alpha2"
    )

    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(180.dp)) {
        // Outer concentric circle 1
        Box(
            modifier = Modifier
                .size(140.dp)
                .graphicsLayer(scaleX = pulse1, scaleY = pulse1, alpha = alpha1)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.6f), CircleShape)
        )

        // Middle concentric circle 2
        Box(
            modifier = Modifier
                .size(110.dp)
                .graphicsLayer(scaleX = pulse2, scaleY = pulse2, alpha = alpha2)
                .border(1.5.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.5f), CircleShape)
        )

        // Center Identity Disc
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.7f)),
            shadowElevation = 4.dp,
            modifier = Modifier.size(76.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.06f),
                    modifier = Modifier.size(62.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(34.dp)
                        )
                    }
                }

                // Tiny Green Live Ping Dot
                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.secondary,
                    border = BorderStroke(1.5.dp, Color.White),
                    modifier = Modifier
                        .size(14.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = (-4).dp, y = (-4).dp)
                ) {}
            }
        }
    }
}
