package com.android.nbaapp.di.mainActivity.homeFragment.newsFragment

import com.android.nbaapp.data.repos.HomeRepository
import dagger.Subcomponent

@Subcomponent
interface RepositorySubComponent {
    fun inject(repo: HomeRepository)

    @Subcomponent.Builder
    interface Builder {
        fun build() : RepositorySubComponent

    }
}