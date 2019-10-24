package com.android.nbaapp.data.vms

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.nbaapp.data.db.enitities.NewsEntity
import com.android.nbaapp.data.repos.SingleNewsRepository
import com.android.nbaapp.di.mainActivity.singleNewsFragment.SingleNewsScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@SingleNewsScope
class SingleNewsViewModel @Inject constructor(private val repository: SingleNewsRepository) :
    ViewModel() {
    var id:Int? = null
    var data: LiveData<NewsEntity>? = null

    fun setId(newsId:Int) {
        this.id = newsId
        data = repository.getSingleNews(id)
    }

    fun setFavorite(fav:Boolean, id:Int) = viewModelScope.launch { repository.setFav(fav, id) }


}