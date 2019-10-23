package com.android.nbaapp.di.mainActivity

import com.android.nbaapp.di.mainActivity.homeFragment.ChildFragmentBuilder
import com.android.nbaapp.di.mainActivity.homeFragment.HomeFragmentScope
import com.android.nbaapp.di.mainActivity.homeFragment.HomeModule
import com.android.nbaapp.di.mainActivity.homeFragment.addFragment.AddFragmentScope
import com.android.nbaapp.di.mainActivity.homeFragment.addFragment.AddViewModelModule
import com.android.nbaapp.di.mainActivity.homeFragment.allGamesFragment.AllGamesScope
import com.android.nbaapp.di.mainActivity.homeFragment.newsFragment.HomeViewModelModule
import com.android.nbaapp.di.mainActivity.singleNewsFragment.SingleNewsFragmentViewModelModule
import com.android.nbaapp.di.mainActivity.singleNewsFragment.SingleNewsScope
import com.android.nbaapp.ui.fragments.nestedFragments.GamesFragment
import com.android.nbaapp.ui.fragments.HomeFragment
import com.android.nbaapp.ui.fragments.SingleNewsFragment
import com.android.nbaapp.ui.fragments.nestedFragments.AddFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @HomeFragmentScope
    @ContributesAndroidInjector(modules = [ChildFragmentBuilder::class, HomeViewModelModule::class, HomeModule::class])
    abstract fun HomeFragment() : HomeFragment

    @AddFragmentScope
    @ContributesAndroidInjector(modules = [AddViewModelModule::class])
    abstract fun addFragment() : AddFragment

    @SingleNewsScope
    @ContributesAndroidInjector(modules = [SingleNewsFragmentViewModelModule::class])
    abstract fun singleNewsFragments() : SingleNewsFragment



}
