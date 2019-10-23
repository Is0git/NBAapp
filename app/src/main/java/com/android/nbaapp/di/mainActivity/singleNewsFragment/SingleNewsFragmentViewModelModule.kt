package com.android.nbaapp.di.mainActivity.singleNewsFragment

import androidx.lifecycle.ViewModel
import com.android.nbaapp.data.vms.SingleNewsViewModel
import com.android.nbaapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SingleNewsFragmentViewModelModule {
    @Binds
    @IntoMap
    @SingleNewsScope
    @ViewModelKey(SingleNewsViewModel::class)
    abstract fun getViewModel(viewModel: SingleNewsViewModel): ViewModel
}