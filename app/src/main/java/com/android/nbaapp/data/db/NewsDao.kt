package com.android.nbaapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.nbaapp.data.db.enitities.NewsEntity

@Dao
interface NewsDao {
    @Query("SELECT * FROM NEWS_TABLE")
    fun getNews() : LiveData<NewsEntity>

    @Insert
    suspend fun addNews(newsEntity: NewsEntity)
}