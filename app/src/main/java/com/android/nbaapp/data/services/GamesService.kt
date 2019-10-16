package com.android.nbaapp.data.services

import com.android.nbaapp.utils.header_host
import com.android.nbaapp.utils.header_key
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GamesService {

    @GET("games/league/leag/year")
    suspend fun <T> getGames(
        @Path("leag") league: String,
        @Path("year") season_year: String,
        @Header("X-RapidAPI-Host") host: String = header_host,
        @Header("X-RapidAPI-Key") key: String = header_key
    ) : Response<T>
}