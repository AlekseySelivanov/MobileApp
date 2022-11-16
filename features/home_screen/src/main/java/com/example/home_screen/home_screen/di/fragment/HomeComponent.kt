package com.example.home_screen.home_screen.di.fragment

import com.example.common.di.Screen
import com.example.home_screen.home_screen.di.HomeScreenComponent
import com.example.home_screen.home_screen.ui.HomeFragment
import dagger.Component

@Component(
    dependencies = [HomeScreenComponent::class],
    modules = [HomeFragmentModule::class]
)
@Screen
interface HomeComponent {
    fun provideHomeFragmentComponent(homeFragment: HomeFragment)
}