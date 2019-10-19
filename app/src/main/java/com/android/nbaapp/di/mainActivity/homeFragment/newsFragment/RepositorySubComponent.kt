package com.android.nbaapp.di.mainActivity.homeFragment.newsFragment

import com.android.nbaapp.data.repos.NewsRepository
import dagger.Subcomponent

@Subcomponent
interface RepositorySubComponent {
    fun inject(repo: NewsRepository)

    @Subcomponent.Builder
    interface Builder {
        fun build() : RepositorySubComponent

    }
}