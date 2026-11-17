package com.example.kotlinpractice

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Задание 8. Трекер воды.
@Composable
fun WaterTracker(modifier: Modifier = Modifier) {
    var waterCount by rememberSaveable { mutableIntStateOf(100) }
    var streakDays by rememberSaveable { mutableIntStateOf(0) }
    val primaryColor = Color(0xFF435F91)
    val secondaryColor = Color(0xFF586174)
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Трекер воды", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = primaryColor)
        Spacer(Modifier.height(48.dp))
        Text("$waterCount мл", fontSize = 48.sp, fontWeight = FontWeight.Bold, color = secondaryColor)
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = { waterCount += 250 },
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor, contentColor = Color.White)
        ) { Text("+250 мл", fontSize = 18.sp, fontWeight = FontWeight.Bold) }
        Spacer(Modifier.height(16.dp))
        OutlinedButton(onClick = {
            streakDays = if (waterCount >= 1500) streakDays + 1 else 0
            waterCount = 0
        }) { Text("Завершить день", fontSize = 18.sp) }
        Spacer(Modifier.height(24.dp))
        Text("Дней подряд с нормой: $streakDays", fontSize = 18.sp, color = secondaryColor)
    }
}
