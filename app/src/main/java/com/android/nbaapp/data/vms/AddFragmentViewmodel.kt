package com.android.nbaapp.data.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.nbaapp.data.db.enitities.NewsEntity
import com.android.nbaapp.data.repos.AddFragmentRepository
import com.android.nbaapp.di.mainActivity.homeFragment.addFragment.AddFragmentScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AddFragmentScope
class AddFragmentViewmodel @Inject constructor(private val repository: AddFragmentRepository) : ViewModel() {

   fun addNews(news:NewsEntity)  = viewModelScope.launch {  repository.addNews(news)}

}