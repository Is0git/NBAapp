package com.android.nbaapp.data.vms

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.nbaapp.data.db.enitities.NewsEntity
import com.android.nbaapp.data.repos.SingleNewsRepository
import com.android.nbaapp.di.mainActivity.singleNewsFragment.SingleNewsScope
import javax.inject.Inject

@SingleNewsScope
class SingleNewsViewModel @Inject constructor(private val repository: SingleNewsRepository) :
    ViewModel() {

    private lateinit var news: NewsEntity
    fun getSingleNews(id: Int): LiveData<NewsEntity> = repository.getSingleNews(id)


}