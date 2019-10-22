package com.android.nbaapp.data.vms

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.data.repos.AllGamesRepository
import javax.inject.Inject

class AllGamesViewModel @Inject constructor(repository: AllGamesRepository) : ViewModel() {
    lateinit var allGamespageList: LiveData<PagedList<GamesPojo.Data>>
    lateinit var config:PagedList.Config
    init {
        config = PagedList.Config.Builder().setPageSize(5).setEnablePlaceholders(false).build()
        allGamespageList = LivePagedListBuilder(repository.datasourceFactory, config).build()
    }
}