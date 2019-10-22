package com.android.nbaapp.di.mainActivity.homeFragment.allGamesFragment

import androidx.lifecycle.ViewModel
import com.android.nbaapp.data.vms.AllGamesViewModel
import com.android.nbaapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GamesViewModelsModule {
    @Binds
    @IntoMap
    @AllGamesScope
    @ViewModelKey(AllGamesViewModel::class)
    protected abstract fun bindGamesViewModel(viewModel: AllGamesViewModel) : ViewModel
}