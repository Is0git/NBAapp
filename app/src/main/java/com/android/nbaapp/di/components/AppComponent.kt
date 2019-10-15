package com.android.nbaapp.di.components

import android.app.Application
import com.android.nbaapp.App
import com.android.nbaapp.di.modules.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class, RetrofitModule::class])
@Singleton
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(application: Application): Builder
    }
}