package com.tisbus.kotlinchat.data.room.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tisbus.kotlinchat.data.room.dao.MessageDao
import com.tisbus.kotlinchat.domain.entity.Message

@Database(entities = [Message::class], version = 2, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun messageDao() : MessageDao

    companion object{
        private var INSTANCE : DataBase? = null
        private const val DB_NAME = "message"
        private val LOCK = Any()

        fun getInstance(application: Application) : DataBase{
            INSTANCE?.let{
                return it
            }
            synchronized(LOCK){
                INSTANCE?.let{
                    return it
                }
                val db = Room.databaseBuilder(application, DataBase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}