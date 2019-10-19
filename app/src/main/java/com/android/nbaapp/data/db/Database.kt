package com.android.nbaapp.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.nbaapp.data.db.enitities.NewsEntity
import javax.inject.Inject
import javax.inject.Singleton

@Database(entities = [NewsEntity::class], version = 1, exportSchema = true)
@Singleton
abstract class Database @Inject constructor(application: Application) : RoomDatabase() {
    abstract fun NewsDao() : NewsDao
    init {
        Room.databaseBuilder(application, com.android.nbaapp.data.db.Database::class.java,  "main_database").fallbackToDestructiveMigration().build()
    }
}