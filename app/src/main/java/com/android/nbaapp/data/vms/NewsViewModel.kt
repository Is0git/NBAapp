package com.android.nbaapp.data.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.nbaapp.data.db.enitities.NewsEntity
import com.android.nbaapp.data.repos.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    val data = repository.getGames()

    val news = repository.getAllNews()

    fun addNews(newsEntity: NewsEntity) = viewModelScope.launch { repository.addNews(newsEntity) }

    fun deleteNews() = viewModelScope.launch { repository.deleteAll() }


}