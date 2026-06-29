package com.deepanjan.tas

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TasApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
