package com.android.nbaapp.di

import com.android.nbaapp.MainActivity
import com.android.nbaapp.di.mainActivity.FragmentBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    abstract  fun MainActivitity() : MainActivity

}