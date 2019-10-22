package com.android.nbaapp.data.services

import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.utils.header_host
import com.android.nbaapp.utils.header_key
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GamesService {

    @GET("games")
    suspend fun  getGames(
        @Query("Seasons") season_year: String,
        @Query("page") page:String = "0",
        @Query("per_page") page_size:String = "25",
        @Header("X-RapidAPI-Host") host: String = header_host,
        @Header("X-RapidAPI-Key") key: String = header_key
    ) : Response<GamesPojo.SeasonGames>


}