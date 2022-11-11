package com.example.home_screen.home_screen.di

import com.example.common.di.CoreComponent
import com.example.common.di.Screen
import com.example.home_screen.home_screen.HotSalesFragment
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [HomeFragmentModule::class]
)
@Screen
interface HotSalesComponent {
    fun provideHotSalesFragmentComponent(hotSalesFragment: HotSalesFragment)
}