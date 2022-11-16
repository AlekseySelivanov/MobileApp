package com.example.effectivemobile.di.mainActivity

import com.example.cart_screen.di.CartComponent
import com.example.common.di.CoreComponent
import com.example.common.di.MainScope
import com.example.effectivemobile.ui.MainActivity
import com.example.home_screen.home_screen.di.HomeScreenComponent
import com.example.liked_screen.di.LikedScreenComponent
import com.example.product_details_screen.di.ProductDetailsScreenComponent
import dagger.Component

@Component(
    dependencies = [CoreComponent::class, CartComponent::class, HomeScreenComponent::class, LikedScreenComponent::class, ProductDetailsScreenComponent::class],
    modules = [MainActivityModule::class]
)
@MainScope
interface MainActivityComponent {
    fun provideMainActivityComponent(mainActivity: MainActivity)
}