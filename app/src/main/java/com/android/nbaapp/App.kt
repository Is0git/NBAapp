package com.android.nbaapp


import android.util.Log
import com.android.nbaapp.di.AppComponent
import com.android.nbaapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import retrofit2.Retrofit
import javax.inject.Inject

class App : DaggerApplication() {
    @Inject
    lateinit var test:Retrofit
    lateinit var app: AppComponent
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build().also { app = it }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("SSS", "LOLO: $test")
    }

}