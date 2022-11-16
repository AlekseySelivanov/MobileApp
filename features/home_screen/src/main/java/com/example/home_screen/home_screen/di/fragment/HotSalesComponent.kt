package com.example.home_screen.home_screen.di.fragment

import com.example.common.di.Screen
import com.example.home_screen.home_screen.di.HomeScreenComponent
import com.example.home_screen.home_screen.ui.HotSalesFragment
import dagger.Component

@Component(
    dependencies = [HomeScreenComponent::class],
    modules = [HotSalesFragmentModule::class]
)
@Screen
interface HotSalesComponent {
    fun provideHotSalesFragmentComponent(hotSalesFragment: HotSalesFragment)
}