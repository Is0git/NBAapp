package com.android.nbaapp.di.mainActivity.homeFragment.addFragment

import androidx.lifecycle.ViewModel
import com.android.nbaapp.data.vms.AddFragmentViewmodel
import com.android.nbaapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AddViewModelModule {
    @Binds
    @IntoMap
    @AddFragmentScope
    @ViewModelKey(AddFragmentViewmodel::class)
    abstract fun getAddViewModel(viewModel: AddFragmentViewmodel) : ViewModel


}