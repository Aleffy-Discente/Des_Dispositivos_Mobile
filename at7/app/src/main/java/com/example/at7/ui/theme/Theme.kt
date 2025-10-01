package com.example.at7.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF2563EB),
    secondary = androidx.compose.ui.graphics.Color(0xFF03DAC6),
    background = androidx.compose.ui.graphics.Color(0xFFF7F7FB),
    surface = androidx.compose.ui.graphics.Color(0xFFFFFFFF),
    onPrimary = androidx.compose.ui.graphics.Color.White,
    onSecondary = androidx.compose.ui.graphics.Color.Black,
    onBackground = androidx.compose.ui.graphics.Color.Black,
    onSurface = androidx.compose.ui.graphics.Color.Black,
)

@Composable
fun At7Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = MaterialTheme.typography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}
