package com.example.liked_screen.di

import androidx.lifecycle.ViewModel
import com.example.common.di.viewmodel.ViewModelBuilderModule
import com.example.common.di.viewmodel.ViewModelKey
import com.example.liked_screen.presentation.viewModel.LikedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelBuilderModule::class])
abstract class LikedFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(LikedViewModel::class)
    abstract fun bindLikedViewModel(likedViewModel: LikedViewModel): ViewModel
}