package com.example.newsdemo

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Inside Application Class Now")
    }

    companion object {
        const val TAG = "ApplicationClass"
    }
}