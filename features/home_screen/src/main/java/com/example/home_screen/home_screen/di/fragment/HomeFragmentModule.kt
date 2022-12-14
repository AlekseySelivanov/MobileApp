package com.example.home_screen.home_screen.di.fragment

import androidx.lifecycle.ViewModel
import com.example.common.di.viewmodel.ViewModelBuilderModule
import com.example.common.di.viewmodel.ViewModelKey
import com.example.home_screen.home_screen.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelBuilderModule::class])
abstract class HomeFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}