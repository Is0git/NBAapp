package com.android.nbaapp.di.modules

import com.android.nbaapp.di.scopes.HomeFragmentScope
import com.android.nbaapp.ui.fragments.GamesFragment
import com.android.nbaapp.ui.fragments.HomeFragment
import com.android.nbaapp.ui.fragments.NewsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [])
abstract class FragmentBuilder {
    @ContributesAndroidInjector
    @HomeFragmentScope
    abstract fun HomeFragment() : HomeFragment

    @ContributesAndroidInjector
    abstract fun GamesFragment() : GamesFragment

    @ContributesAndroidInjector
    abstract fun NewsFragment() : NewsFragment
}