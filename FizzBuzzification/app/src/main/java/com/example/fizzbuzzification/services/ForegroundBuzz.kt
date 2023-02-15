package com.example.fizzbuzzification.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.fizzbuzzification.MainActivity
import com.example.fizzbuzzification.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ForegroundBuzz : Service() {
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

    private lateinit var pendingIntent: PendingIntent

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
        showNotification()
        iterateTilLimit(startId)
        return START_STICKY
    }

    private fun iterateTilLimit(startId: Int) = scope.launch {
        for (currentNumber in BoundBuzz.LOWER_LIMIT..BoundBuzz.UPPER_LIMIT) {
            if (currentNumber % BoundBuzz.NOTIFICATION_INCREMENT == 0) updateNotification(
                currentNumber
            )

            show(
                "onStartCommand: result was ${fizzBuzz(currentNumber)}"
            )
            delay(BoundBuzz.MAX_DELAY)
        }
        stopSelf(startId)
    }

    fun show(msg: String) {
        Log.e(TAG, "show: $msg ")
    }


    private fun showNotification() {
        pendingIntent = Intent(this.applicationContext, MainActivity::class.java).let {
            PendingIntent.getActivity(
                this.applicationContext,
                0,
                it,
                PendingIntent.FLAG_IMMUTABLE
            )
        }
        val notification = NotificationCompat.Builder(this.applicationContext, CHANNEL_ID)
            .setContentTitle("Fizzy Notification")
            .setContentText(getString(R.string.content_text, 0))
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .setTicker("Tahhh Daaahhh, I'm here")
            .build()

        startForeground(NOTIFICATION_ID, notification)
    }

    private fun updateNotification(currentNumber: Int) {
        val notification = NotificationCompat.Builder(this.applicationContext, CHANNEL_ID)
            .setContentTitle("Fizzy Notification")
            .setContentText(getString(R.string.content_text, currentNumber))
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setTicker("Tahhh Daaahhh, I'm here")
            .setContentIntent(pendingIntent)
            .build()

        NotificationManagerCompat.from(this.applicationContext)
            .notify(NOTIFICATION_ID, notification)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val notificationChannel = NotificationChannel(
            CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
        )
        (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).apply {
            createNotificationChannel(notificationChannel)
        }
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
        const val TAG = "ForegroundBuzz"
        const val FIZZ = 3
        const val BUZZ = 5
        const val FIZZBUZZ = 15
        const val ZERO = 0
        const val UPPER_LIMIT = 1500
        const val LOWER_LIMIT = 1
        const val MAX_DELAY = 300L

        const val CHANNEL_ID = "690"
        const val CHANNEL_NAME = "PARTY_BUS_CHANNEL"

        const val NOTIFICATION_ID = 5234
        const val NOTIFICATION_INCREMENT = 15

    }
}
