package com.example.home_screen.home_screen.di

import androidx.lifecycle.ViewModel
import com.example.common.di.viewmodel.ViewModelBuilderModule
import com.example.common.di.viewmodel.ViewModelKey
import com.example.home_screen.home_screen.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelBuilderModule::class])
abstract class HotSalesFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}