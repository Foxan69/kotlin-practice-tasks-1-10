# Практическая работа 2 — Kotlin и Jetpack Compose

**Лисенков Андрей Михайлович · ИКБО-61-24**

Исходный код заданий 1–10: приветствие, текст, кнопки, изображения,
компоновки контактов, трекер воды и корзина товаров. Интерфейс использует
Jetpack Compose и Material 3.

## Код заданий

| Задание | Реализация |
| --- | --- |
| 1 | [Приветствие и обработка null](app/src/main/java/com/example/kotlinpractice/MainActivity.kt#L76) |
| 2 | [Центрирование и предпросмотры](app/src/main/java/com/example/kotlinpractice/MainActivity.kt#L85) |
| 3 | [Форматирование текста](app/src/main/java/com/example/kotlinpractice/MainActivity.kt#L104) |
| 4 | [Оформление кнопки](app/src/main/java/com/example/kotlinpractice/MainActivity.kt#L146) |
| 5 | [Круг с инициалами ЛАМ](app/src/main/java/com/example/kotlinpractice/MainActivity.kt#L166) |
| 6 | [Изображение и преобразования](app/src/main/java/com/example/kotlinpractice/MainActivity.kt#L186) |
| 7 | [Контакты, Column и Row](app/src/main/java/com/example/kotlinpractice/MainActivity.kt#L211) |
| 8 | [Трекер воды](app/src/main/java/com/example/kotlinpractice/MainActivity.kt#L296) |
| 9 | [Четыре UI-теста трекера воды](app/src/androidTest/java/com/example/kotlinpractice/ExampleInstrumentedTest.kt) |
| 10 | [Корзина товаров](app/src/main/java/com/example/kotlinpractice/MainActivity.kt#L328) |

## Как запустить

1. Открой в Android Studio проект **Empty Activity** с поддержкой Compose и Material 3.
2. Используй пакет `com.example.kotlinpractice` и тему `KotlinPracticeTheme`.
3. Скопируй файлы из `app/src` в соответствующие каталоги проекта.
4. Если темы ещё нет, добавь [optional/Theme.kt](optional/Theme.kt) в пакет
   `com.example.kotlinpractice.ui.theme`.
5. В начале [MainActivity.kt](app/src/main/java/com/example/kotlinpractice/MainActivity.kt)
   установи `TASK` от 1 до 10 и запусти приложение. По умолчанию выбрано задание 10.
6. Для вариантов задания 7 установи `CONTACT_MODE`: 1 — один контакт,
   2 — список из трёх контактов, 3 — контакт со звездой.

Подробности настройки зависимостей, Preview и запуска тестов:
[инструкция](docs/SETUP.md).

## Тесты и результаты

[ExampleInstrumentedTest.kt](app/src/androidTest/java/com/example/kotlinpractice/ExampleInstrumentedTest.kt)
содержит четыре проверки: видимость элементов, добавление 250 мл,
два успешных дня подряд и сброс серии ниже нормы 1500 мл.

Тесты запускаются в Android Studio из класса `ExampleInstrumentedTest`
на эмуляторе или подключённом устройстве. При публикации репозитория
повторная сборка и запуск тестов не выполнялись.

## Состав

- `app/src/main/java` — экраны заданий и логика приложения.
- `app/src/androidTest` — инструментальные UI-тесты.
- `app/src/main/res` — строковые и векторные ресурсы.
- `optional/Theme.kt` — тема для нового проекта.
- `docs/SETUP.md` — инструкция по подключению и проверке.

Набор предназначен для подключения к проекту Android Studio;
Gradle-файлы и SDK в него не входят. Исходники подготовлены на основе
учебного архива с заданиями и отчёта. Телефоны и адреса в примере контактов
заменены учебными значениями.
