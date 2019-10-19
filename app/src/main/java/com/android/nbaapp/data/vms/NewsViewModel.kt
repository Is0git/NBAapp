package com.android.nbaapp.data.vms

import androidx.lifecycle.ViewModel
import com.android.nbaapp.data.repos.NewsRepository
import retrofit2.Retrofit
import javax.inject.Inject

class NewsViewModel @Inject constructor(repository: NewsRepository) : ViewModel() {


    val data = repository.getGames()

}