package com.example.makeupbeauty

import android.app.Application
import com.androidisland.vita.startVita

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startVita()
    }
}