package com.mobiledevcampus.notemark.core.presentation.design_system

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ColorScheme.OnSurfaceVariant: Color
    get() = OnSurfaceVar



val AppColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    surface = Surface,
    onSurface = OnSurface,
    error = Error,
)

@Composable
fun NoteMarkTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}