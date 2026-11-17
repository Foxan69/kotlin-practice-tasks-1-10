# Подключение исходников и запуск

## Как вставить в существующий KotlinPractice

1. Распакуй архив.
2. Открой в Android Studio проект KotlinPractice с Jetpack Compose и Material 3.
3. Замени ВЕСЬ текст MainActivity.kt файлом из папки app/src/main/java/com/example/kotlinpractice/.
   Сначала кликни в редактор кода, затем Cmd+A (Mac) или Ctrl+A (Windows/Linux) и вставь код.
   Не добавляй второй package и второй набор импортов в конец старого файла.
4. Скопируй circle.xml в app/src/main/res/drawable/.
5. В strings.xml добавь compose_description из приложенного файла внутрь существующего
   блока <resources>. Если заменяешь strings.xml целиком, учти, что другие твои строки
   должны быть сохранены. В файле должен быть только один блок <resources>.
6. Если KotlinPracticeTheme уже есть, сохрани существующую тему. Резервная тема лежит
   в optional/Theme.kt. Она нужна только при отсутствии этой функции в проекте.
7. В MainActivity.kt поменяй TASK на номер нужного задания и нажми Run app.

MainActivity.kt содержит код ВСЕХ экранов. Копировать их одновременно в отдельные
Kotlin-файлы не нужно: иначе появятся дубли объявлений. Задания переключаются константой.

## Как выбрать экран

| Экран | Что установить в начале MainActivity.kt |
| --- | --- |
| 1. Приветствие | TASK = 1, greetingName = "Андрей" |
| 1. Имя не задано | TASK = 1, greetingName = null |
| 2. Приветствие по центру | TASK = 2 |
| 3. Три способа оформления текста | TASK = 3 |
| 4. Серая кнопка | TASK = 4 |
| 5. Инициалы ЛАМ | TASK = 5 |
| 6. Два изображения круга | TASK = 6 |
| 7. Один контакт | TASK = 7, CONTACT_MODE = 1 |
| 7. Три серые карточки | TASK = 7, CONTACT_MODE = 2 |
| 7. Контакт со звездой | TASK = 7, CONTACT_MODE = 3 |
| 8. Трекер воды | TASK = 8 |
| 9. Тот же трекер для ручного запуска | TASK = 9 |
| 10. Корзина | TASK = 10 |

Для задания 2 открой Preview/Split у MainActivity.kt. У HelloPreview есть три
аннотации @Preview: portrait, landscape и round. Они не переключаются кнопкой в приложении.

## Задание 8 — проверка вручную

- Начало: 100 мл, серия 0.
- Шесть нажатий «+250 мл»: 1600 мл.
- «Завершить день»: 0 мл, серия 1.
- Ещё одно завершение без воды: 0 мл, серия 0.
- После обнуления шесть нажатий дают ровно 1500 мл; это также успешный день.

rememberSaveable сохраняет значения при пересоздании экрана, например при повороте.
Это не полноценная база данных: сохранение после любого нового запуска не гарантируется.
Если нужен исходный результат 100 мл для скриншота, очисти данные приложения
через настройки эмулятора и запусти его заново.

## Задание 9 — тесты

Файл app/src/androidTest/java/com/example/kotlinpractice/ExampleInstrumentedTest.kt
заменяет пример теста. Это каталог androidTest, а не test и не main.

В app/build.gradle.kts внутри android/defaultConfig должна быть строка:

```kotlin
testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
```

Если используешь прежний каталог libs, убедись, что в dependencies уже есть эти строки.
Добавлять их повторно не нужно:

```kotlin
androidTestImplementation(platform(libs.androidx.compose.bom))
androidTestImplementation(libs.androidx.compose.ui.test.junit4)
androidTestImplementation(libs.androidx.junit)
androidTestImplementation(libs.androidx.espresso.core)
debugImplementation(libs.androidx.compose.ui.test.manifest)
```

После изменения Gradle нажми Sync Now. Для запуска всех четырёх тестов нажми
зелёный треугольник СЛЕВА от строки class ExampleInstrumentedTest и выбери Run.
Верхняя кнопка Run app запускает обычное приложение.

Тесты проверяют наличие элементов, увеличение на 250 мл, два успешных дня подряд
(включая границу 1500 мл) и сброс серии при 1000 мл.
Они сами открывают WaterTracker через createComposeRule, поэтому выбранный TASK
не влияет на тестовый экран. Новая сборка и запуск UI-тестов при публикации репозитория не выполнялись.
Скриншот «4 passed» в отчёте относится к ранее выполненному запуску.

Версии Android Gradle Plugin, Kotlin, Compose и Espresso задаются в существующем
проекте Android Studio. В репозиторий включены исходные файлы, а не Gradle-окружение.

## Задание 10 — корзина

Начальные цены 100, 150 и 56 рублей: сумма 306 рублей.
Каждое добавление создаёт случайную цену от 1 до 100 рублей включительно,
поэтому последующие суммы могут отличаться от снимков PDF.
Последовательность из отчёта 36, 70, 80 и 56 даёт 548 рублей; удаление последнего
товара уменьшает эту сумму до 492 рублей.
При добавлении проверяется обновлённая сумма: если она больше 500, появляется Toast.
При пустом списке выводится 0 рублей и скрывается кнопка удаления.

## Где находится код

Все файлы доступны по отдельности в репозитории. Основной код находится в MainActivity.kt,
автотесты — в каталоге androidTest, резервная тема — в optional/Theme.kt.

## Документация

- Тестирование Compose: https://developer.android.com/develop/ui/compose/testing
- Масштабирование и цвет изображения: https://developer.android.com/develop/ui/compose/graphics/images/customize
