package com.example.product_details_screen.di.fragment

import com.example.common.di.Screen
import com.example.product_details_screen.di.ProductDetailsScreenComponent
import com.example.product_details_screen.ui.ProductDetailsFragment
import dagger.Component

@Component(
    dependencies = [ProductDetailsScreenComponent::class],
    modules = [ProductDetailsFragmentModule::class]
)
@Screen
interface ProductDetailsComponent {
    fun provideProductDetailsFragmentComponent(productDetailsFragment: ProductDetailsFragment)
}