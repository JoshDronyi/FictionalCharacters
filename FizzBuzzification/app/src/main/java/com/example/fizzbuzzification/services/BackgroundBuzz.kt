package com.example.fizzbuzzification.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BackgroundBuzz : Service() {
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(
            TAG,
            "exceptionHandler: Oh no something went wrong!!! :/ \n ${throwable.localizedMessage} ",
        )
    }
    private val scope = CoroutineScope(
        SupervisorJob() +
                Dispatchers.Default +
                exceptionHandler +
                CoroutineName("Yo Mama's service")
    )

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        scope.launch {
            for (currentNumber in LOWER_LIMIT..UPPER_LIMIT) {
                Log.e(TAG,
                    "onStartCommand: result was ${fizzBuzz(currentNumber)}")
                delay(MAX_DELAY)
            }
            stopSelf(startId)
        }
        return START_STICKY
    }

    private fun fizzBuzz(value: Int): String = when {
        value % FIZZBUZZ == ZERO -> {
            "Fizz the Buzz off"
        }
        value % FIZZ == ZERO -> {
            "Fizzz Yea"
        }
        value % BUZZ == ZERO -> {
            "Buzz it"
        }
        else -> {
            value.toString()
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    companion object {
        const val TAG = "BackgroundBuzz"
        const val FIZZ = 3
        const val BUZZ = 5
        const val FIZZBUZZ = 15
        const val ZERO = 0
        const val UPPER_LIMIT = 1500
        const val LOWER_LIMIT = 1
        const val MAX_DELAY = 300L
    }
}
