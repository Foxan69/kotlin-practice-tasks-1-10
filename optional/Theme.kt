package com.example.kotlinpractice.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Используй этот файл только если в проекте отсутствует KotlinPracticeTheme.
private val AppColors = lightColorScheme(
    primary = Color(0xFF505F8B),
    onPrimary = Color.White,
    background = Color(0xFFFAF8FF),
    surface = Color(0xFFFAF8FF),
    onBackground = Color(0xFF32333D),
    onSurface = Color(0xFF32333D)
)

@Composable
fun KotlinPracticeTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = AppColors, content = content)
}
