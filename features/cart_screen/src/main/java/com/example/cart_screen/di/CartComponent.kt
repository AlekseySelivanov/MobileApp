package com.example.cart_screen.di

import com.example.cart_screen.MyCartFragment
import com.example.common.di.CoreComponent
import com.example.common.di.Screen
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [CartFragmentModule::class]
)
@Screen
interface CartComponent {
    fun provideMyCartFragmentComponent(myCartFragment: MyCartFragment)
}