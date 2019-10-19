package com.android.nbaapp.di.mainActivity.homeFragment.newsFragment

import androidx.lifecycle.ViewModel
import com.android.nbaapp.data.vms.NewsViewModel
import com.android.nbaapp.di.mainActivity.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewsViewModelsModule {
    @Binds
    @IntoMap
    @NewsFragmentScope
    @ViewModelKey(NewsViewModel::class)
    protected abstract fun bindNewsViewModel(viewModel: NewsViewModel) : ViewModel
}