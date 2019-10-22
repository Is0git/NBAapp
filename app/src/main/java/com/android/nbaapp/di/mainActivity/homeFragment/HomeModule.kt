package com.android.nbaapp.di.mainActivity.homeFragment

import androidx.fragment.app.FragmentPagerAdapter
import com.android.nbaapp.ui.adapters.ViewPagerAdapter
import com.android.nbaapp.ui.fragments.HomeFragment
import dagger.Module
import dagger.Provides

@Module
object HomeModule {
    @Provides
    @HomeFragmentScope
    @JvmStatic
    fun getViewPagerAdapter(homeFragment: HomeFragment) : ViewPagerAdapter = ViewPagerAdapter(homeFragment.childFragmentManager, FragmentPagerAdapter.POSITION_UNCHANGED)

}