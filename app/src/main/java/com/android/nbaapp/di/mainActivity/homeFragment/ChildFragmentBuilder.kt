package com.android.nbaapp.di.mainActivity.homeFragment

import com.android.nbaapp.di.mainActivity.homeFragment.allGamesFragment.AllGamesScope
import com.android.nbaapp.di.mainActivity.homeFragment.allGamesFragment.GamesViewModelsModule
import com.android.nbaapp.di.mainActivity.homeFragment.newsFragment.NewsFragmentModule
import com.android.nbaapp.di.mainActivity.homeFragment.newsFragment.NewsFragmentScope
import com.android.nbaapp.di.mainActivity.homeFragment.newsFragment.NewsViewModelsModule
import com.android.nbaapp.ui.fragments.nestedFragments.GamesFragment
import com.android.nbaapp.ui.fragments.nestedFragments.NewsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ChildFragmentBuilder {
    @ContributesAndroidInjector(modules = [NewsFragmentModule::class, NewsViewModelsModule::class])
    @NewsFragmentScope
    abstract fun NewsFragment() : NewsFragment

    @ContributesAndroidInjector(modules = [GamesViewModelsModule::class])
    @AllGamesScope
    abstract fun allGamesFragment() : GamesFragment
}
