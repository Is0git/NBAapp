package com.android.nbaapp.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.android.nbaapp.data.vms.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {
    @Binds
    @Singleton
    abstract fun viewModelFactory(viewModelFactory: ViewModelFactory) : ViewModelProvider.Factory
}