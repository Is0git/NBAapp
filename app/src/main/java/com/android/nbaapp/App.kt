package com.android.nbaapp


import android.util.Log
import com.android.nbaapp.di.components.AppComponent
import com.android.nbaapp.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import javax.inject.Inject

class App : DaggerApplication() {
    @Inject
    lateinit var test:Retrofit
    lateinit var app: AppComponent
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build().also { app = it }
    }


}