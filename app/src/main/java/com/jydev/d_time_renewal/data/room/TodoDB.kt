package com.jydev.d_time_renewal.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jydev.d_time_renewal.model.TodoData

@Database(entities = [TodoData::class], version = 1 , exportSchema = false)
abstract class TodoDB : RoomDatabase(){
    abstract fun todoDao() : TodoDao
    object Factory{
        private const val dbName = "todo.db"
        fun create(context: Context): TodoDB {
            return Room.databaseBuilder(
                context.applicationContext,
                TodoDB::class.java,
                dbName
            )
                .allowMainThreadQueries()
                .build()
        }
    }

}