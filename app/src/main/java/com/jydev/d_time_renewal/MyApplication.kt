package com.jydev.d_time_renewal

import android.app.Application
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {

        }
    }
}