package com.android.nbaapp.di.modules

import com.android.nbaapp.data.repos.HomeRepository
import dagger.Subcomponent


@Subcomponent
interface RepositorySubComponent {
    fun inject(homeRepository: HomeRepository)
    @Subcomponent.Builder
    interface Builder {
        fun build(): RepositorySubComponent
    }
}
