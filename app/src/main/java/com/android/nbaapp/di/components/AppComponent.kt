package com.android.nbaapp.di.components

import android.app.Application
import com.android.nbaapp.App
import com.android.nbaapp.data.repos.HomeRepository
import com.android.nbaapp.di.modules.ActivityBuilder
import com.android.nbaapp.di.modules.RepositorySubComponent
import com.android.nbaapp.di.modules.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class, RetrofitModule::class, ActivityBuilder::class])
@Singleton
interface AppComponent : AndroidInjector<App> {

    fun getHome(): RepositorySubComponent.Builder

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(application: Application): Builder
    }
}