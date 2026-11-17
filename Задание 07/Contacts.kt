package com.example.kotlinpractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Задание 7. Контакты и компоновки Column и Row.
private const val CONTACT_MODE = 3

data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String,
    val address: String
)

private val contacts = listOf(
    Contact("Андрей", "Михайлович", "Лисенков", "+7 000 000-00-01",
        "Учебный адрес 1"),
    Contact("Василий", "Егорович", "Кузякин", "—",
        "Учебный адрес 2"),
    Contact("Людмила", "Прокофьевна", "Калугина", "+7 000 000-00-02",
        "Учебный адрес 3")
)

@Composable
fun ContactScreen(modifier: Modifier = Modifier) {
    when (CONTACT_MODE) {
        1 -> ContactColumn(contacts.first(), modifier)
        2 -> ContactListScreen(modifier)
        3 -> ContactRowScreen(modifier)
    }
}

@Composable
fun ContactColumn(contact: Contact, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text("Имя: ${contact.name}")
        Text("Отчество: ${contact.patronymic}")
        Text("Фамилия: ${contact.surname}")
        Text("Мобильный телефон: ${contact.phone}")
        Text("Адрес: ${contact.address}")
    }
}

@Composable
fun ContactLines(contact: Contact) {
    val lines = listOf(
        "Имя: ${contact.name}", "Отчество: ${contact.patronymic}",
        "Фамилия: ${contact.surname}", "Мобильный телефон: ${contact.phone}",
        "Адрес: ${contact.address}"
    )
    lines.forEach { line ->
        Text(line, modifier = Modifier.fillMaxWidth(), color = Color.Black,
            fontSize = 14.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun ContactListScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        contacts.forEach { contact ->
            Column(
                modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) { ContactLines(contact) }
        }
    }
}

@Composable
fun ContactRowScreen(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(8.dp)
            .background(Color.LightGray).padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            ContactLines(contacts.first())
        }
        Image(
            painter = painterResource(android.R.drawable.star_big_on),
            contentDescription = "Избранный контакт",
            modifier = Modifier.size(24.dp)
        )
    }
}
