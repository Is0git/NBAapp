package com.android.nbaapp.data.repos

import com.android.nbaapp.data.dataSourceFactories.GamesDataFactory
import javax.inject.Inject

class AllGamesRepository @Inject constructor(val datasourceFactory:GamesDataFactory) {

}