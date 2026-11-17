package com.example.kotlinpractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinpractice.ui.theme.KotlinPracticeTheme
import kotlin.random.Random

// Выбери задание от 1 до 10. Для задания 9 запускаются тесты трекера.
private const val TASK = 10

// Задание 7: 1 — один контакт; 2 — три контакта; 3 — контакт со звездой.
private const val CONTACT_MODE = 3

// Для проверки отсутствующего имени замени "Андрей" на null.
private val greetingName: String? = "Андрей"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinPracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val screenModifier = Modifier.padding(innerPadding)
                    when (TASK) {
                        1 -> Hello(greetingName, screenModifier)
                        2 -> HelloCentered("Андрей", screenModifier)
                        3 -> TextFormattingScreen(screenModifier)
                        4 -> ButtonScreen(screenModifier)
                        5 -> InitialsScreen(screenModifier)
                        6 -> ImageScreen(screenModifier)
                        7 -> ContactScreen(screenModifier)
                        8, 9 -> WaterTracker(screenModifier)
                        10 -> CartScreen(screenModifier)
                    }
                }
            }
        }
    }
}

// Задание 1.
@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (name == null) "Имя не задано" else "Привет, $name!",
        modifier = modifier
    )
}

// Задание 2.
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
    KotlinPracticeTheme { HelloCentered("Андрей") }
}

// Задание 3.
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

// Задание 4.
@Composable
fun ButtonScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            )
        ) {
            Text("Нажми на меня", fontSize = 18.sp)
        }
    }
}

// Задание 5.
@Composable
fun InitialsScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxWidth().height(100.dp)
                .background(Color.Gray).padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.fillMaxHeight().aspectRatio(1f)
                    .background(Color(0xFF1565C0), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("ЛАМ", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

// Задание 6. Требуется ресурс res/drawable/circle.xml.
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

// Задание 7.
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

// Задания 8 и 9.
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

// Задание 10.
data class Product(val id: Int, val name: String, val price: Int)

@Composable
fun CartScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var prices by rememberSaveable { mutableStateOf(listOf(100, 150, 56)) }
    val products = prices.mapIndexed { index, price -> Product(index + 1, "Товар #${index + 1}", price) }
    val total = products.sumOf { it.price }
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Корзина", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        if (products.isEmpty()) Text("Корзина пуста", fontSize = 16.sp)
        products.forEach { product ->
            Text("${product.name} — ${product.price} рублей", fontSize = 18.sp)
        }
        Text("Товаров на сумму: $total рублей", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val updatedPrices = prices + Random.nextInt(1, 101)
                prices = updatedPrices
                if (updatedPrices.sum() > 500) {
                    Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
                }
            }
        ) { Text("Добавить товар") }
        if (products.isNotEmpty()) {
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { prices = prices.dropLast(1) }
            ) { Text("Удалить товар") }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun WaterTrackerPreview() {
    KotlinPracticeTheme { WaterTracker() }
}
