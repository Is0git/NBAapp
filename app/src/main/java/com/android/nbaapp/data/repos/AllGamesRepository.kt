package com.android.nbaapp.data.repos

import com.android.nbaapp.data.dataSourceFactories.GamesDataFactory
import com.android.nbaapp.di.mainActivity.homeFragment.allGamesFragment.AllGamesScope
import javax.inject.Inject
@AllGamesScope
class AllGamesRepository @Inject constructor(val datasourceFactory:GamesDataFactory) {

}