package com.android.nbaapp.di.mainActivity.homeFragment.newsFragment

import android.content.Context
import com.android.nbaapp.MainActivity
import dagger.Module
import dagger.Provides

@Module
object NewsFragmentModule {

    @Provides
    @NewsFragmentScope
    @JvmStatic
    fun getText() : String = "hihi"

}