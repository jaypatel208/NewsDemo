package com.example.newsdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        const val TAG = "ApplicationClass"
    }
}