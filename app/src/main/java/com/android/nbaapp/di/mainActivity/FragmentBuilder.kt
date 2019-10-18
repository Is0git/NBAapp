package com.android.nbaapp.di.mainActivity

import com.android.nbaapp.di.mainActivity.homeFragment.ChildFragmentBuilder
import com.android.nbaapp.di.mainActivity.homeFragment.newsFragment.NewsFragmentModule
import com.android.nbaapp.di.mainActivity.homeFragment.newsFragment.NewsFragmentScope
import com.android.nbaapp.ui.fragments.GamesFragment
import com.android.nbaapp.ui.fragments.HomeFragment
import com.android.nbaapp.ui.fragments.NewsFragment
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector(modules = [ChildFragmentBuilder::class])
    abstract fun HomeFragment() : HomeFragment

    @ContributesAndroidInjector
    abstract fun GamesFragment() : GamesFragment


}
