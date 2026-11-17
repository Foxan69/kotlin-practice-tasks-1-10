package com.example.kotlinpractice

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.compose.material3.MaterialTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// Задание 9. UI тесты трекера воды.
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

