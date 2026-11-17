package com.example.kotlinpractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// Задание 6. Вывод изображения.
@Composable
fun ImageScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Исходный круг справа сверху")
        Box(modifier = Modifier.size(240.dp, 120.dp).background(Color.Black)) {
            Image(
                painter = painterResource(R.drawable.circle),
                contentDescription = "Оранжевый круг",
                modifier = Modifier.size(48.dp).align(Alignment.TopEnd)
            )
        }
        Text("Растянутый круг с изменённым цветом")
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Фиолетовый растянутый круг",
            modifier = Modifier.size(240.dp, 120.dp).background(Color.Blue),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF800080))
        )
    }
}
