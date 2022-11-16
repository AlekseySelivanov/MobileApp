package com.example.liked_screen.di.fragment

import com.example.common.di.Screen
import com.example.liked_screen.di.LikedScreenComponent
import com.example.liked_screen.ui.LikedFragment
import dagger.Component

@Component(
    dependencies = [LikedScreenComponent::class],
    modules = [LikedFragmentModule::class]
)
@Screen
interface LikedComponent {
    fun provideLikedFragmentComponent(likedFragment: LikedFragment)
}