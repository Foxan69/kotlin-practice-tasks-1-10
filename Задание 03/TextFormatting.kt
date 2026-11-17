package com.example.kotlinpractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Задание 3. Форматирование текста.
@Composable
fun TextFormattingScreen(modifier: Modifier = Modifier) {
    val description = stringResource(R.string.compose_description)
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Зелёный курсив по центру", style = MaterialTheme.typography.titleMedium)
        Text(
            text = description,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
        Text("Одна строка с многоточием", style = MaterialTheme.typography.titleMedium)
        Text(
            text = description,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text("Подчёркивание и отступ первой строки", style = MaterialTheme.typography.titleMedium)
        Text(
            text = description,
            modifier = Modifier.fillMaxWidth().background(Color.Green),
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                textDecoration = TextDecoration.Underline,
                textIndent = TextIndent(firstLine = 48.sp)
            )
        )
    }
}
