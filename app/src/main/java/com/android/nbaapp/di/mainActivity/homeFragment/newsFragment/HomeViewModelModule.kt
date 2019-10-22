package com.android.nbaapp.di.mainActivity.homeFragment.newsFragment

import androidx.lifecycle.ViewModel
import com.android.nbaapp.data.vms.HomeViewModel
import com.android.nbaapp.di.ViewModelKey
import com.android.nbaapp.di.mainActivity.homeFragment.HomeFragmentScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {
    @Binds
    @HomeFragmentScope
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel:HomeViewModel) : ViewModel
}