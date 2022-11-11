package com.example.product_details_screen.di

import com.example.common.di.CoreComponent
import com.example.common.di.Screen
import com.example.product_details_screen.products_details_screen.ProductDetailsFragment
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [ProductDetailsFragmentModule::class]
)
@Screen
interface ProductDetailsComponent {
    fun provideProductDetailsFragmentComponent(productDetailsFragment: ProductDetailsFragment)
}