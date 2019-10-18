package com.android.nbaapp.di.mainActivity

import com.android.nbaapp.ui.fragments.GamesFragment
import com.android.nbaapp.ui.fragments.HomeFragment
import com.android.nbaapp.ui.fragments.NewsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector
    abstract fun HomeFragment() : HomeFragment

    @ContributesAndroidInjector
    abstract fun GamesFragment() : GamesFragment

    @ContributesAndroidInjector
    abstract fun NewsFragment() : NewsFragment
}