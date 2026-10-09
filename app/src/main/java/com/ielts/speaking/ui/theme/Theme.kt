package com.ielts.speaking.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFB9C3FF), // Sapphire Light Accent
    onPrimary = Color(0xFF001257),
    primaryContainer = Color(0xFF1B2A6B),
    onPrimaryContainer = Color(0xFFDDE1FF),
    secondary = Color(0xFF51DEA2), // Mint Emerald Light
    onSecondary = Color(0xFF003824),
    secondaryContainer = Color(0xFF005236),
    onSecondaryContainer = Color(0xFF6EF8BA),
    tertiary = Color(0xFFFFB955), // Oxford Amber Light
    onTertiary = Color(0xFF452A00),
    tertiaryContainer = Color(0xFF633F00),
    onTertiaryContainer = Color(0xFFFFDDB4),
    background = Color(0xFF131316),
    onBackground = Color(0xFFE4E2DF),
    surface = Color(0xFF1B1C1F),
    onSurface = Color(0xFFE4E2DF),
    surfaceVariant = Color(0xFF26262B),
    onSurfaceVariant = Color(0xFFC6C5D2),
    outline = Color(0xFF767681),
    error = Color(0xFFFFB4AB)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF001256), // Deep Academic Sapphire
    onPrimary = Color.White,
    primaryContainer = Color(0xFF1B2A6B),
    onPrimaryContainer = Color(0xFFDDE1FF),
    secondary = Color(0xFF006C49), // Mint Emerald
    onSecondary = Color.White,
    secondaryContainer = Color(0xFF6EF8BA),
    onSecondaryContainer = Color(0xFF002113),
    tertiary = Color(0xFFD08900), // Oxford Amber
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFFFDDB4),
    onTertiaryContainer = Color(0xFF291800),
    background = Color(0xFFFBF9F6), // Warm Bone / Cream
    onBackground = Color(0xFF1B1C1A),
    surface = Color(0xFFFFFFFF), // Pure White Card Surface
    onSurface = Color(0xFF1B1C1A),
    surfaceVariant = Color(0xFFF1EDE6), // Subtle Task Card Header Band
    onSurfaceVariant = Color(0xFF454650),
    outline = Color(0xFFC6C5D2),
    outlineVariant = Color(0xFFE6E0D6),
    error = Color(0xFFBA1A1A)
)

@Composable
fun IeltsSpeakingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
