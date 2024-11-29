package com.example.androidlazycolumnlazyrow

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .border(1.dp, Color.Black)
                ) {
                    Text(
                        "Фрукты",
                        Modifier
                            .padding(2.dp),
                        fontSize = 18.sp
                    )
                }
                LazyRow(
                    modifier = Modifier
                        .padding(5.dp)
                        .border(1.dp, Color.Black)
                        .padding(2.dp)
                        .background(Color.White)
                ) {
                    items(fruits) {
                        ItemFruit(it)
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .border(1.dp, Color.Black)
                ) {
                    Text(
                        "Другие фрукты",
                        Modifier
                            .padding(2.dp),
                        fontSize = 18.sp
                    )
                }
                LazyColumn (
                    modifier = Modifier
                        .padding(5.dp)
                        .border(1.dp, Color.Black)
                        .padding(2.dp)
                        .background(Color.White)
                ) {
                    items(fruits) {
                        ItemFruit(it)
                    }
                }
            }
        }
    }
}

class Fruit(
    val name: String,
    val image: Int,
    val price: Double,
)

val fruits = arrayListOf(
    Fruit("Банан", R.drawable.banana, (10..100).random().toDouble()),
    Fruit("Айва", R.drawable.quince, (10..100).random().toDouble()),
    Fruit("Инжир", R.drawable.figs, (10..100).random().toDouble()),
    Fruit("Кумкват", R.drawable.kumquat, (10..100).random().toDouble()),
    Fruit("Гранат", R.drawable.garnet, (10..100).random().toDouble()),
    Fruit("Ананас", R.drawable.pineapple, (10..100).random().toDouble()),
    Fruit("Папая", R.drawable.papaya, (10..100).random().toDouble()),
    Fruit("Кешью", R.drawable.cashews, (10..100).random().toDouble()),
)


@Composable
fun ItemFruit(fruit: Fruit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(5.dp)
            .background(Color.Blue)

    ) {
        Image(
            painter = painterResource(id = fruit.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = "${fruit.name}, (${fruit.price})",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}

