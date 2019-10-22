package com.android.nbaapp.data.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.nbaapp.data.repos.HomeRepository
import com.android.nbaapp.di.mainActivity.homeFragment.HomeFragmentScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HomeFragmentScope
class HomeViewModel @Inject constructor(val repository: HomeRepository) : ViewModel() {

    fun deleteAllNews() = viewModelScope.launch { repository.deleteAll()}
}