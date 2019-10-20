package com.android.nbaapp.di.mainActivity

import android.content.Context
import com.android.nbaapp.ui.activities.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @MainActivityScope
    @ActivityContextQualifier
    fun getActivityContext(mainActivity: MainActivity): Context = mainActivity

}