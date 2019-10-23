package com.android.nbaapp.data.repos

import com.android.nbaapp.data.db.MainDatabase
import com.android.nbaapp.di.mainActivity.singleNewsFragment.SingleNewsScope
import javax.inject.Inject
@SingleNewsScope
class SingleNewsRepository @Inject constructor(private val database: MainDatabase) {

    fun getSingleNews(id:Int?) = database.NewsDao().getSingleNews(id)

    suspend fun setFav(fav:Boolean, id:Int){
        database.NewsDao().setFavorite(fav, id)
    }

}