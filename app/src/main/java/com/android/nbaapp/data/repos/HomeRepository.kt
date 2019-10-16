package com.android.nbaapp.data.repos

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.data.services.GamesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import javax.inject.Inject

class HomeRepository(val app: Application) {

    val games = MutableLiveData<GamesPojo.AllGames>()

    @Inject
    lateinit var retrofit: Retrofit


     fun getGames(): LiveData<GamesPojo.AllGames> = runBlocking {
        val service = retrofit.create(GamesService::class.java)
        launch(Dispatchers.IO) {
            val result = service.getGames<GamesPojo.AllGames>(
                "standard",
                "2019"
            ).apply {
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
        operator fun invoke(app: Application) = repo ?: init(app)

        fun init(app: Application) : HomeRepository {
            repo = HomeRepository(app)
            return repo!!
        }
    }
}