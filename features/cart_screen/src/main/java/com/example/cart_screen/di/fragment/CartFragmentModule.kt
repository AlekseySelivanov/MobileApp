package com.example.cart_screen.di.fragment

import androidx.lifecycle.ViewModel
import com.example.cart_screen.ui.viewModel.MyCartViewModel
import com.example.common.di.viewmodel.ViewModelBuilderModule
import com.example.common.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelBuilderModule::class])
abstract class CartFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(MyCartViewModel::class)
    abstract fun bindMyCartViewModel(myCartViewModel: MyCartViewModel): ViewModel
}