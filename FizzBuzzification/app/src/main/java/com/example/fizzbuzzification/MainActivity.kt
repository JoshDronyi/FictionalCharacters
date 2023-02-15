package com.example.fizzbuzzification

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fizzbuzzification.services.BackgroundBuzz
import com.example.fizzbuzzification.services.BoundBuzz
import com.example.fizzbuzzification.services.BuzzBinder
import com.example.fizzbuzzification.services.BuzzEvent
import com.example.fizzbuzzification.ui.screens.HomeScreen
import com.example.fizzbuzzification.ui.theme.FizzBuzzificationTheme


class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"

    lateinit var binder: BuzzBinder
    var isConnected: MutableState<Boolean> = mutableStateOf(false)

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            binder = service as BuzzBinder
            isConnected.value = true
            Log.e(TAG, "onServiceConnected: Yooo we on that buuuuuzzzzz $name")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isConnected.value = false
            Log.e(TAG, "onServiceDisconnected: Ayyoooo $name, what happenned to my buuuzzz?")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawApp(isConnected = isConnected.value)
        }
    }

    @Composable
    private fun DrawApp(isConnected: Boolean) {
        if (isConnected) {
            val itemValue by binder.currentCount.collectAsState()
            FizzBuzzApp(itemValue) { event: BuzzEvent ->
                when (event) {
                    BuzzEvent.StartService -> {
                        Log.e(BackgroundBuzz.TAG, "onCreate: Starting this bizznatch.")
                        startBoundService()

                    }
                    BuzzEvent.StopService -> binder.stopService()
                    is BuzzEvent.StartFrom -> {
                        binder.startFrom(event.startingPoint)
                    } //make sealed class so we can get this as a variable
                    BuzzEvent.PauseService -> binder.pauseService()
                    BuzzEvent.ContinueService -> binder.continueService()
                }
            }
        } else {
            ErrorScreen("Yooooo why we not got no jawns daaawwwggg?")
            startBoundService()
        }
    }


    private fun startBoundService() = Intent(this, BoundBuzz::class.java).apply {
        startService(this)
    }

    override fun onStart() {
        super.onStart()
        Intent(this, BoundBuzz::class.java).apply {
            bindService(this, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
    }

    override fun onDestroy() {
        stopService(Intent(this, BoundBuzz::class.java))
        super.onDestroy()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorScreen(errorMsg: String) {
    Card(
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors().apply {
            this.containerColor(enabled = true)
            this.contentColor(enabled = true)
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                imageVector = Icons.Default.Warning,
                contentDescription = "Icon for the error",
                colorFilter = ColorFilter.tint(
                    Color.Red,
                    BlendMode.ColorBurn
                )
            )
            Text(
                text = errorMsg,
                color = Color.Red
            )
        }
    }

}

@Composable
fun FizzBuzzApp(
    currentValue: String,
    onActionSelect: (event: BuzzEvent) -> Unit
) {
    FizzBuzzificationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(
                currentValue,
                stopService = { onActionSelect(BuzzEvent.StopService) },
                pauseService = { onActionSelect(BuzzEvent.PauseService) },
                continueService = { onActionSelect(BuzzEvent.ContinueService) },
                startServiceFrom = {
                    onActionSelect(BuzzEvent.StartFrom(it))
                }
            ) {
                onActionSelect(BuzzEvent.StartService)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val TAG = "DefaultPreview"
    FizzBuzzificationTheme {
        HomeScreen(
            "",
            {}, {}, {}, {}
        ) {
            Log.e(TAG, "DefaultPreview: GEt Buzzed.")
        }
    }
}