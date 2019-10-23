package com.android.nbaapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.nbaapp.data.db.enitities.NewsEntity

@Dao
interface NewsDao {
    @Query("SELECT * FROM NEWS_TABLE")
    fun getNews() : LiveData<List<NewsEntity>>

    @Insert
    suspend fun addNews(newsEntity: NewsEntity)

    @Query("DELETE FROM NEWS_TABLE")

    suspend fun deleteAll()

    @Query("SELECT * FROM NEWS_TABLE WHERE id == (:newsId)")
    fun getSingleNews(newsId:Int) : LiveData<NewsEntity>
}