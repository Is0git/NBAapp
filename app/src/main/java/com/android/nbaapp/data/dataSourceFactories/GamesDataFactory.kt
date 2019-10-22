package com.android.nbaapp.data.dataSourceFactories

import androidx.paging.DataSource
import com.android.nbaapp.data.dataSources.GamesDataSource
import com.android.nbaapp.data.models.GamesPojo
import com.android.nbaapp.di.mainActivity.homeFragment.allGamesFragment.AllGamesScope
import javax.inject.Inject

@AllGamesScope
class GamesDataFactory @Inject constructor(val dataSource:GamesDataSource) : DataSource.Factory<Int, GamesPojo.Data>() {

    override fun create(): DataSource<Int, GamesPojo.Data> {
        return dataSource
    }
}