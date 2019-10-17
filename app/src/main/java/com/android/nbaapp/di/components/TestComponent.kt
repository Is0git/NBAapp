package com.android.nbaapp.di.components

import com.android.nbaapp.data.repos.HomeRepository
import com.android.nbaapp.di.modules.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface TestComponent {

    fun inject(repos: HomeRepository)
}