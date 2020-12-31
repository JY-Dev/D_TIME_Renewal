package com.jydev.d_time_renewal

import android.app.Application
import com.jydev.d_time_renewal.data.Repository
import com.jydev.d_time_renewal.data.TodoRepositoryImpl
import com.jydev.d_time_renewal.data.room.TodoDB
import com.jydev.d_time_renewal.model.todo.TodoData
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(module)
        }
    }

    val module = module {
        single<Repository<TodoData>> { TodoRepositoryImpl(TodoDB.Factory.create(get()).todoDao()) }
    }
}