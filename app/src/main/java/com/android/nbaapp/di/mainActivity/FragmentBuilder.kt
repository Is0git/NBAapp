package com.android.nbaapp.di.mainActivity

import com.android.nbaapp.di.mainActivity.homeFragment.ChildFragmentBuilder
import com.android.nbaapp.di.mainActivity.homeFragment.HomeFragmentScope
import com.android.nbaapp.di.mainActivity.homeFragment.allGamesFragment.AllGamesScope
import com.android.nbaapp.di.mainActivity.homeFragment.newsFragment.HomeViewModelModule
import com.android.nbaapp.ui.fragments.nestedFragments.GamesFragment
import com.android.nbaapp.ui.fragments.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @HomeFragmentScope
    @ContributesAndroidInjector(modules = [ChildFragmentBuilder::class, HomeViewModelModule::class])
    abstract fun HomeFragment() : HomeFragment


}
