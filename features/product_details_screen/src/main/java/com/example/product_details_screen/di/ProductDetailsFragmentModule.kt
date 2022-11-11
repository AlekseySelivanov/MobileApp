package com.example.product_details_screen.di

import androidx.lifecycle.ViewModel
import com.example.common.di.viewmodel.ViewModelBuilderModule
import com.example.common.di.viewmodel.ViewModelKey
import com.example.product_details_screen.products_details_screen.viewModel.ProductDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelBuilderModule::class])
abstract class ProductDetailsFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailsViewModel::class)
    abstract fun bindProductDetailsViewModel(productDetailsViewModel: ProductDetailsViewModel): ViewModel
}