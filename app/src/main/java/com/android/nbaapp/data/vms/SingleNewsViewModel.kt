package com.android.nbaapp.data.vms

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.nbaapp.data.db.enitities.NewsEntity
import com.android.nbaapp.data.repos.SingleNewsRepository
import com.android.nbaapp.di.mainActivity.singleNewsFragment.SingleNewsScope
import javax.inject.Inject

@SingleNewsScope
class SingleNewsViewModel @Inject constructor(private val repository: SingleNewsRepository) :
    ViewModel() {
    var id:Int? = null
    val data: LiveData<NewsEntity> = repository.getSingleNews(5).also { Log.d("TAG", "DID IT WORK?") }


}