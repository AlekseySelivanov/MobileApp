package com.example.product_details_screen.di.fragment

import com.example.common.di.Screen
import com.example.product_details_screen.di.ProductDetailsScreenComponent
import com.example.product_details_screen.ui.PDItemFragment
import dagger.Component

@Component(
    dependencies = [ProductDetailsScreenComponent::class],
    modules = [PDItemFragmentModule::class]
)
@Screen
interface PDItemComponent {
    fun providePDItemFragmentComponent(pdItemFragment: PDItemFragment)
}