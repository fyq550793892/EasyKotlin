package com.example.easycloudkotlin

import android.app.Application
import android.content.res.Configuration
import com.yatoooon.screenadaptation.ScreenAdapterTools

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ScreenAdapterTools.init(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        ScreenAdapterTools.getInstance().reset(this)
    }
}