package com.example.kotlinpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinpractice.ui.theme.KotlinPracticeTheme

data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String,
    val address: String
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            KotlinPracticeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ContactListScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ContactListScreen(modifier: Modifier = Modifier) {
    val contacts = listOf(
        Contact(
            name = "Андрей",
            patronymic = "Михайлович",
            surname = "Лисенков",
            phone = "+7 916 504-30-03",
            address = "г. Подольск, ул. Новомосковская, д. 67"
        ),
        Contact(
            name = "Василий",
            patronymic = "Егорович",
            surname = "Кузякин",
            phone = "—",
            address = "Ивановская область, дер. Крутово, д. 4"
        ),
        Contact(
            name = "Людмила",
            patronymic = "Прокофьевна",
            surname = "Калугина",
            phone = "+7 495 788 78 78",
            address = "г. Москва, Большая Никитская, д. 43, кв. 290"
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        contacts.forEach { contact ->
            ContactCard(contact = contact)
        }
    }
}

@Composable
fun ContactCard(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        ContactLine(text = "Имя: ${contact.name}")
        ContactLine(text = "Отчество: ${contact.patronymic}")
        ContactLine(text = "Фамилия: ${contact.surname}")
        ContactLine(text = "Мобильный телефон: ${contact.phone}")
        ContactLine(text = "Адрес: ${contact.address}")
    }
}

@Composable
fun ContactLine(text: String) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Black,
        fontSize = 14.sp,
        textAlign = TextAlign.Center
    )
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640
)
@Composable
fun ContactListPreview() {
    KotlinPracticeTheme {
        ContactListScreen()
    }
}
