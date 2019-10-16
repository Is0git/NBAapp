package com.android.nbaapp.data

import com.squareup.moshi.Json

object GamesPojo {


data class AllGames(val api: Api)

data class Api(
    val status: Int,
    val message: String,
    val results: Int,
    val filters: List<String>,
    val games: List<Games>
)

data class Games(
    val seasonYear:String?,
    val league:String?,
    val gameId:String?,
    val arena:String?,
    val city:String?,
    val country:String?,
    val clock:String?,
    val gameDuration:String?,
    val currentPeriod:String?,
    val halftime:String?,
    val EndOfPeriod:String?,
    val seasonState:String?,
    val statusGame:String?,
    val vTeam:Team?,
    val hTeam:Team?
)

data class Team(
    val teamId:String?,
    val shortName:String?,
    val fullName:String?,
    val nickName:String?,
    @Json(name = "logo")
    val logo_url:String?,
    val score:Score?

)

data class Score(val points:String?)
}
