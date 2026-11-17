package com.example.kotlinpractice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// Задание 2. Настройка предпросмотра.
@Composable
fun HelloCentered(name: String?, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Hello(name)
    }
}

@Preview(name = "portrait", showBackground = true, showSystemUi = true,
    widthDp = 360, heightDp = 640)
@Preview(name = "landscape", showBackground = true, showSystemUi = true,
    widthDp = 640, heightDp = 360)
@Preview(name = "round", showBackground = true, backgroundColor = 0xFFFFFF00,
    device = "spec:shape=Round,width=200,height=200,unit=dp,dpi=160")
@Composable
fun HelloPreview() {
    MaterialTheme { HelloCentered("Андрей") }
}
