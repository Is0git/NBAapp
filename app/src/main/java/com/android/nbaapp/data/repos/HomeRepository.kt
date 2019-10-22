package com.android.nbaapp.data.repos

import androidx.room.RoomDatabase
import com.android.nbaapp.data.db.MainDatabase
import com.android.nbaapp.di.mainActivity.homeFragment.HomeFragmentScope
import javax.inject.Inject
@HomeFragmentScope
class HomeRepository @Inject constructor(val database: MainDatabase) {

    suspend fun deleteAll() {database.NewsDao().deleteAll()}
}