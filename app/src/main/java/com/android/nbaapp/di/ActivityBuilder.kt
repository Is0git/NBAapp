package com.android.nbaapp.di

import com.android.nbaapp.ui.activities.MainActivity
import com.android.nbaapp.di.mainActivity.FragmentBuilder
import com.android.nbaapp.di.mainActivity.MainActivityModule
import com.android.nbaapp.di.mainActivity.MainActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [FragmentBuilder::class, MainActivityModule::class])
    @MainActivityScope
    abstract  fun MainActivitity() : MainActivity

}