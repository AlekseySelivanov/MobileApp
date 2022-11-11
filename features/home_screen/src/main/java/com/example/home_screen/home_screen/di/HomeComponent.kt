package com.example.home_screen.home_screen.di

import com.example.common.di.CoreComponent
import com.example.common.di.Screen
import com.example.home_screen.home_screen.HomeFragment
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [HomeFragmentModule::class]
)
@Screen
interface HomeComponent {
    fun provideHomeFragmentComponent(homeFragment: HomeFragment)
}