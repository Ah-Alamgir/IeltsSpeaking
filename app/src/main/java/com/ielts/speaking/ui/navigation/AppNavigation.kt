package com.ielts.speaking.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.ielts.speaking.call.PeerJsCallManager
import com.ielts.speaking.ui.call.AudioCallScreen
import com.ielts.speaking.ui.chat.PersonalChatScreen
import com.ielts.speaking.ui.profile.ProfileScreen
import com.ielts.speaking.ui.speaking.SpeakingDetailScreen
import com.ielts.speaking.ui.speaking.SpeakingScreen
import com.ielts.speaking.ui.writing.WritingDetailScreen
import com.ielts.speaking.ui.writing.WritingScreen

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Speaking : BottomNavItem("speaking_list", "Speaking", Icons.Default.RecordVoiceOver)
    object Writing : BottomNavItem("writing_list", "Writing", Icons.Default.Edit)
    object AudioCall : BottomNavItem("audio_call", "Live Call", Icons.Default.Call)
    object PersonalChat : BottomNavItem("personal_chat", "Direct Chat", Icons.AutoMirrored.Filled.Message)
    object Profile : BottomNavItem("profile", "Profile", Icons.Default.Person)
}

@Composable
fun AppNavigation(callManager: PeerJsCallManager) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: BottomNavItem.Speaking.route

    val bottomNavItems = listOf(
        BottomNavItem.Speaking,
        BottomNavItem.Writing,
        BottomNavItem.AudioCall,
        BottomNavItem.PersonalChat,
        BottomNavItem.Profile
    )

    val showBottomBar = currentRoute in listOf(
        BottomNavItem.Speaking.route,
        BottomNavItem.Writing.route,
        BottomNavItem.AudioCall.route,
        BottomNavItem.PersonalChat.route,
        BottomNavItem.Profile.route
    )

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.surface,
                    border = androidx.compose.foundation.BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.6f)
                    ),
                    shadowElevation = 8.dp
                ) {
                    NavigationBar(
                        containerColor = Color.Transparent,
                        tonalElevation = 0.dp,
                        windowInsets = WindowInsets.navigationBars
                    ) {
                        bottomNavItems.forEach { item ->
                            val selected = currentRoute == item.route
                            NavigationBarItem(
                                icon = {
                                    Box {
                                        Icon(
                                            imageVector = item.icon,
                                            contentDescription = item.title,
                                            tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                                            modifier = Modifier.size(24.dp)
                                        )
                                        if (item == BottomNavItem.AudioCall) {
                                            // Tiny live indicator dot
                                            Surface(
                                                shape = CircleShape,
                                                color = MaterialTheme.colorScheme.secondary,
                                                modifier = Modifier
                                                    .size(7.dp)
                                                    .align(Alignment.TopEnd)
                                            ) {}
                                        }
                                    }
                                },
                                label = {
                                    Text(
                                        text = item.title,
                                        fontWeight = if (selected) FontWeight.ExtraBold else FontWeight.Medium,
                                        fontSize = 11.sp,
                                        color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                },
                                selected = selected,
                                onClick = {
                                    if (currentRoute != item.route) {
                                        navController.navigate(item.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f),
                                    selectedIconColor = MaterialTheme.colorScheme.primary,
                                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        var activePartnerForChat by remember { mutableStateOf<String?>(null) }

        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Speaking.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Speaking.route) {
                SpeakingScreen(
                    onQuestionClick = { questionId ->
                        navController.navigate("speaking_detail/$questionId")
                    }
                )
            }

            composable(
                route = "speaking_detail/{questionId}",
                arguments = listOf(navArgument("questionId") { type = NavType.StringType })
            ) { backStackEntry ->
                val qId = backStackEntry.arguments?.getString("questionId") ?: ""
                SpeakingDetailScreen(
                    questionId = qId,
                    onBackClick = { navController.popBackStack() }
                )
            }

            composable(BottomNavItem.Writing.route) {
                WritingScreen(
                    onQuestionClick = { questionId ->
                        navController.navigate("writing_detail/$questionId")
                    }
                )
            }

            composable(
                route = "writing_detail/{questionId}",
                arguments = listOf(navArgument("questionId") { type = NavType.StringType })
            ) { backStackEntry ->
                val qId = backStackEntry.arguments?.getString("questionId") ?: ""
                WritingDetailScreen(
                    questionId = qId,
                    onBackClick = { navController.popBackStack() }
                )
            }

            composable(BottomNavItem.AudioCall.route) {
                AudioCallScreen(
                    callManager = callManager,
                    onNavigateToMessages = { partnerId ->
                        activePartnerForChat = partnerId
                        navController.navigate(BottomNavItem.PersonalChat.route)
                    }
                )
            }

            composable(BottomNavItem.PersonalChat.route) {
                PersonalChatScreen(
                    initialPartnerId = activePartnerForChat,
                    callManager = callManager,
                    onStartCallWithPartner = { partnerId ->
                        if (partnerId.isNotBlank()) {
                            callManager.callPartner(partnerId)
                        }
                        navController.navigate(BottomNavItem.AudioCall.route)
                    }
                )
            }

            composable(BottomNavItem.Profile.route) {
                ProfileScreen()
            }
        }
    }
}
