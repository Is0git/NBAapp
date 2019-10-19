package com.android.nbaapp.data.repos

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.nbaapp.App
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.data.services.GamesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton


class HomeRepository(val retrofit: Retrofit) {


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

    companion object {
        var repo: HomeRepository? = null

        operator fun invoke(retrofit: Retrofit) = repo ?: init(retrofit)

        fun init(retrofit: Retrofit) : HomeRepository {
            repo = HomeRepository(retrofit)
            return repo!!
        }
    }
}