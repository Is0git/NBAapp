package com.android.nbaapp.data.vms

import androidx.lifecycle.ViewModel
import com.android.nbaapp.data.repos.HomeRepository
import retrofit2.Retrofit
import javax.inject.Inject

class NewsViewModel @Inject constructor(val retrofit: Retrofit) : ViewModel() {
    init {
        HomeRepository.invoke(retrofit)
    }

    val data = HomeRepository.repo?.getGames()
}