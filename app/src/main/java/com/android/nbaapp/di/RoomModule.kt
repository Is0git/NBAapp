package com.android.nbaapp.di

import android.app.Application
import androidx.room.Room
import com.android.nbaapp.data.db.MainDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module

object RoomModule {
    @Provides
    @JvmStatic
    @Singleton
    fun getDatabase(application: Application) : MainDatabase = synchronized(this) { Room.databaseBuilder(application, MainDatabase::class.java,  "main_database").fallbackToDestructiveMigration().build()}
}