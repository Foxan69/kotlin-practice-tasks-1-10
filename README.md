# Практическая работа 2

Лисенков Андрей Михайлович, ИКБО-61-24.

## Задание 1 — Функция приветствия

[Файл с кодом](%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%2001/Hello.kt)

```kotlin
@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (name == null) "Имя не задано" else "Привет, $name!",
        modifier = modifier
    )
}
```

## Задание 2 — Настройка предпросмотра

[Файл с кодом](%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%2002/Preview.kt)

```kotlin
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
```

## Задание 3 — Форматирование текста

[Файл с кодом](%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%2003/TextFormatting.kt)

```kotlin
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
```

**strings.xml**

```xml
<resources>
    <string name="app_name">KotlinPractice</string>
    <string name="compose_description">Jetpack Compose — это современный набор инструментов для создания пользовательского интерфейса (UI) на Android, разработанный Google</string>
</resources>
```

## Задание 4 — Оформление кнопки

[Файл с кодом](%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%2004/Button.kt)

```kotlin
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
```

## Задание 5 — Круг с инициалами

[Файл с кодом](%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%2005/Initials.kt)

```kotlin
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
```

## Задание 6 — Вывод изображения

[Файл с кодом](%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%2006/Image.kt)

```kotlin
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
```

**circle.xml**

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="48dp"
    android:height="48dp"
    android:viewportWidth="24"
    android:viewportHeight="24">
    <path
        android:fillColor="#FF5722"
        android:pathData="M12,2a10,10 0,1,1 0,20a10,10 0,1,1 0,-20" />
</vector>
```

## Задание 7 — Контакты и компоновки Column и Row

[Файл с кодом](%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%2007/Contacts.kt)

```kotlin
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
```

## Задание 8 — Трекер воды

[Файл с кодом](%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%2008/WaterTracker.kt)

```kotlin
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
```

## Задание 9 — UI тесты трекера воды

[Файл с кодом](%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%2009/WaterTrackerTest.kt)

```kotlin
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp() {
        composeRule.setContent { MaterialTheme { WaterTracker() } }
    }

    @Test
    fun buttonsAndDayCounterAreVisible() {
        composeRule.onNodeWithText("+250 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Завершить день").assertIsDisplayed()
        composeRule.onNodeWithText("100 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Дней подряд с нормой: 0").assertIsDisplayed()
    }

    @Test
    fun addButtonAdds250EachTime() {
        composeRule.onNodeWithText("+250 мл").performClick()
        composeRule.onNodeWithText("350 мл").assertIsDisplayed()
        composeRule.onNodeWithText("+250 мл").performClick()
        composeRule.onNodeWithText("600 мл").assertIsDisplayed()
    }

    @Test
    fun finishDayCountsConsecutiveSuccessfulDays() {
        repeat(6) { composeRule.onNodeWithText("+250 мл").performClick() }
        composeRule.onNodeWithText("1600 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Завершить день").performClick()
        composeRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Дней подряд с нормой: 1").assertIsDisplayed()
        repeat(6) { composeRule.onNodeWithText("+250 мл").performClick() }
        composeRule.onNodeWithText("1500 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Завершить день").performClick()
        composeRule.onNodeWithText("Дней подряд с нормой: 2").assertIsDisplayed()
    }

    @Test
    fun finishDayBelowGoalResetsStreak() {
        repeat(6) { composeRule.onNodeWithText("+250 мл").performClick() }
        composeRule.onNodeWithText("Завершить день").performClick()
        composeRule.onNodeWithText("Дней подряд с нормой: 1").assertIsDisplayed()
        repeat(4) { composeRule.onNodeWithText("+250 мл").performClick() }
        composeRule.onNodeWithText("1000 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Завершить день").performClick()
        composeRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Дней подряд с нормой: 0").assertIsDisplayed()
    }
}

```

## Задание 10 — Корзина товаров

[Файл с кодом](%D0%97%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%2010/Cart.kt)

```kotlin
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
```

