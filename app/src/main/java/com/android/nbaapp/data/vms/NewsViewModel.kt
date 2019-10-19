package com.android.nbaapp.data.vms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.data.repos.HomeRepository
import javax.inject.Inject

class NewsViewModel @Inject constructor(application: Application) : ViewModel() {
    val homeRepository = HomeRepository.invoke(application)

    val data = homeRepository.getGames()
}