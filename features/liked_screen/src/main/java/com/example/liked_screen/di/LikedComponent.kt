package com.example.liked_screen.di

import com.example.common.di.CoreComponent
import com.example.common.di.Screen
import com.example.liked_screen.presentation.LikedFragment
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [LikedFragmentModule::class]
)
@Screen
interface LikedComponent {
    fun provideLikedFragmentComponent(likedFragment: LikedFragment)
}