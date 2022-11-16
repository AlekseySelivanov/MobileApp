package com.example.cart_screen.di.fragment

import com.example.cart_screen.di.CartComponent
import com.example.cart_screen.ui.MyCartFragment
import com.example.common.di.Screen
import dagger.Component

@Component(
    dependencies = [CartComponent::class],
    modules = [CartFragmentModule::class]
)
@Screen
interface CartFragmentComponent {
    fun provideMyCartFragmentComponent(myCartFragment: MyCartFragment)
}