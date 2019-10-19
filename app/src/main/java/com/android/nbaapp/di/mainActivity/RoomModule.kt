package com.android.nbaapp.di.mainActivity

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
    fun getDatabase(application: Application) : MainDatabase =  Room.databaseBuilder(application, MainDatabase::class.java,  "main_database").fallbackToDestructiveMigration().build()
}