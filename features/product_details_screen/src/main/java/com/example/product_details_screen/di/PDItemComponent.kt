package com.example.product_details_screen.di

import com.example.common.di.CoreComponent
import com.example.common.di.Screen
import com.example.product_details_screen.products_details_screen.PDItemFragment
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [PDItemFragmentModule::class]
)
@Screen
interface PDItemComponent {
    fun providePDItemFragmentComponent(pdItemFragment: PDItemFragment)
}