package com.example.kotlinpractice

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

// Задание 10. Корзина товаров.
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
