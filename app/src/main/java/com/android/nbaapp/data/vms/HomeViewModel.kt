package com.android.nbaapp.data.vms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.data.repos.HomeRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    val homeRepository = HomeRepository.invoke(application)

    val data = homeRepository.getGames()
}