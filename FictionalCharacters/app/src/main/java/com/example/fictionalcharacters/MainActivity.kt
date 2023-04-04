package com.example.fictionalcharacters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fictionalcharacters.ui.theme.FictionalCharactersTheme
import com.example.fictionalcharacters.viewmodel.TestViewModel

class MainActivity : ComponentActivity() {
    private val testVM by viewModels<TestViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FictionalCharactersTheme {
                val testState by testVM.dataState.collectAsState()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Text(text = testState.typeList.toString())
                    Divider()
                    Text(text = testState.superHeroList.toString())
                    Divider()
                    Text(text = testState.pokemonInTypeList.toString())
                    Divider()
                    Text(text = testState.pokemonDetails.toString())
                    Divider()
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FictionalCharactersTheme {
        Greeting("Android")
    }
}
