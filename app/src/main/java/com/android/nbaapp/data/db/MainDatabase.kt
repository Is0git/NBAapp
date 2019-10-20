package com.android.nbaapp.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.nbaapp.data.db.enitities.NewsEntity
import javax.inject.Inject
import javax.inject.Singleton

@Database(entities = [NewsEntity::class], version = 3, exportSchema = true)

abstract class MainDatabase  : RoomDatabase() {
    abstract fun NewsDao() : NewsDao

}