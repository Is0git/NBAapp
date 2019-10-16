package com.android.nbaapp.di.modules

import com.android.nbaapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    abstract  fun MainActivitity() : MainActivity
}