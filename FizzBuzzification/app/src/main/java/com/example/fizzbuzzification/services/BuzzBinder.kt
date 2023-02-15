package com.example.fizzbuzzification.services

import android.os.Binder
import kotlinx.coroutines.flow.StateFlow

abstract class BuzzBinder : Binder() {
    abstract val currentCount: StateFlow<String>
    abstract fun startService()
    abstract fun stopService()
    abstract fun startFrom(startValue: Int)
    abstract fun pauseService()
    abstract fun continueService()
}

sealed class BuzzEvent {
    object StartService : BuzzEvent()
    object StopService : BuzzEvent()
    object PauseService : BuzzEvent()
    object ContinueService : BuzzEvent()
    data class StartFrom(val startingPoint: Int) : BuzzEvent()
}