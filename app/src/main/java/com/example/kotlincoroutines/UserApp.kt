package com.example.kotlincoroutines

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UserApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}