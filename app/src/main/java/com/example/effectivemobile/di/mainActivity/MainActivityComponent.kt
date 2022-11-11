package com.example.effectivemobile.di.mainActivity

import com.example.common.di.CoreComponent
import com.example.common.di.Screen
import com.example.effectivemobile.ui.MainActivity
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [MainActivityModule::class]
)
@Screen
interface MainActivityComponent {
    fun provideMainActivityComponent(mainActivity: MainActivity)
}