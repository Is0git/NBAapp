package com.android.nbaapp.data.repos

import androidx.room.RoomDatabase
import com.android.nbaapp.data.db.MainDatabase
import com.android.nbaapp.data.db.enitities.NewsEntity
import com.android.nbaapp.di.mainActivity.homeFragment.addFragment.AddFragmentScope
import javax.inject.Inject

@AddFragmentScope
class AddFragmentRepository @Inject constructor(private val database:MainDatabase) {

    suspend fun addNews(entity: NewsEntity) {
        database.NewsDao().addNews(entity)
    }
}