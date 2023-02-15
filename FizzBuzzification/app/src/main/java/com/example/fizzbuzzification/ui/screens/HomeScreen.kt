package com.example.fizzbuzzification.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

const val MAX_VIEW_Width = .75f
const val MAX_VIEW_HEIGHT = .25f


@Composable
fun RaveTextField(
    onClick: (startingPoint: Int) -> Unit
) {
    Column {
        val text = remember { mutableStateOf("") }
        TextField(
            value = text.value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { newVal: String ->
                text.value = newVal
            })

        RaveText("StartFrom") { onClick(text.value.toInt()) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    currentValue:String,
    stopService: () -> Unit,
    pauseService: () -> Unit,
    continueService: () -> Unit,
    startServiceFrom: (startingPoint: Int) -> Unit,
    startService: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .background(Color.Cyan, RoundedCornerShape(8.dp))
    ) {
        Text(text = "Hit this button if you wanna fizz.")
        Card() {
            Column(
                modifier = Modifier
                    .fillMaxWidth(MAX_VIEW_Width)
                    .fillMaxHeight(MAX_VIEW_HEIGHT)
                    .background(Color.Gray, RoundedCornerShape(16.dp))
            ) {
                Text(text = currentValue)
                RaveText(text = "I can make you buzz.", onClick = { startService() })
            }
        }

        Card() {
            Column {
                Row {
                    RaveText("Stop") { stopService() }
                    RaveText("Pause") { pauseService() }
                }
                Row {
                    RaveText("Continue") { continueService() }
                    RaveTextField { startValue: Int ->
                        startServiceFrom(startValue)
                    }
                }
            }
        }
    }
}

@Composable
fun RaveText(text: String, onClick: () -> Unit) {
    Button(onClick = { onClick() }, modifier = Modifier.background(Color.White)) {
        val color = if (text.contains("fizzbuzz", ignoreCase = true))
            Color.Green
        else if (text.contains("buzz", true))
            Color.Blue
        else if (text.contains("fizz", true))
            Color.Yellow
        else Color.Black
        Text(text = text, color = color)
    }
}


