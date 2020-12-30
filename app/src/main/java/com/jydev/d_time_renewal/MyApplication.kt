package com.jydev.d_time_renewal

import android.app.Application
import com.jydev.d_time_renewal.data.Repository
import com.jydev.d_time_renewal.data.TodoRepositoryImpl
import com.jydev.d_time_renewal.data.room.TodoDB
import com.jydev.d_time_renewal.model.TodoData
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            module {
                single { TodoRepositoryImpl(TodoDB.Factory.create(applicationContext).todoDao()) }
            }
        }
    }
}