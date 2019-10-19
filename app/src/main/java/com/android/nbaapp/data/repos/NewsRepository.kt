package com.android.nbaapp.data.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.nbaapp.data.db.MainDatabase
import com.android.nbaapp.data.db.enitities.NewsEntity
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.data.services.GamesService
import com.android.nbaapp.di.mainActivity.homeFragment.newsFragment.NewsFragmentScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import javax.inject.Inject

@NewsFragmentScope
class NewsRepository @Inject constructor(var retrofit: Retrofit, var database: MainDatabase) {
    init {
        Log.d("SSS", "res: $retrofit")
    }
    val games = MutableLiveData<GamesPojo.SeasonGames>()

     fun getGames(): LiveData<GamesPojo.SeasonGames> = runBlocking {
        val service = retrofit.create(GamesService::class.java)
        launch(Dispatchers.IO) {
            service.getGames(
                "2019").apply {
                if (isSuccessful) games.postValue(body()) else Log.d(
                    "TAG",
                    "Something went wrong: ${message()}"
                )
            }

        }
        return@runBlocking games
    }

    fun getAllNews() : LiveData<List<NewsEntity>> = database.NewsDao().getNews()

    suspend fun addNews(newsEntity: NewsEntity) = database.NewsDao().addNews(newsEntity)
}