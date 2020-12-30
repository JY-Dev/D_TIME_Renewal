package com.jydev.d_time_renewal

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jydev.d_time_renewal.data.Repository
import com.jydev.d_time_renewal.data.TodoRepositoryImpl
import com.jydev.d_time_renewal.data.room.TodoDB
import com.jydev.d_time_renewal.model.TodoData
import io.reactivex.schedulers.Schedulers.single
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
            listOf(module)
        }
    }

    val module = module {
       /* single { TodoDB.Factory.create(get())}
        single { get<TodoDB>().todoDao() }*/
        single { TodoRepositoryImpl() }
    }
}