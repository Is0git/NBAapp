package com.android.nbaapp.di.mainActivity.homeFragment.newsFragment

import dagger.Module
import dagger.Provides

@Module
object NewsFragmentModule {

    @Provides
    @NewsFragmentScope
    @JvmStatic
    fun getText() : String = "hihi"

//    @Provides
//    @NewsFragmentScope
//    @JvmStatic
//    fun getNewsViewModel(viewModelFactory: ViewModelFactory, mainActivity: MainActivity) : NewsViewModel {
//        return ViewModelProviders.of(mainActivity, viewModelFactory).get(NewsViewModel::class.java)
//    }

}