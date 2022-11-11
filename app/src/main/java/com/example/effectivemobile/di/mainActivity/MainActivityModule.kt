package com.example.effectivemobile.di.mainActivity

import androidx.lifecycle.ViewModel
import com.example.common.di.viewmodel.ViewModelBuilderModule
import com.example.common.di.viewmodel.ViewModelKey
import com.example.effectivemobile.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelBuilderModule::class])
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}