package com.example.effectivemobile.di

import com.example.cart_screen.MyCartFragment
import com.example.common.di.*
import com.example.effectivemobile.ApplicationComponent
import com.example.effectivemobile.di.mainActivity.MainActivityModule
import com.example.effectivemobile.ui.MainActivity
import com.example.effectivemobile.ui.splash_screen.SplashActivity
import com.example.home_screen.home_screen.HomeFragment
import com.example.product_details_screen.products_details_screen.PDItemFragment
import com.example.product_details_screen.products_details_screen.ProductDetailsFragment
import com.example.liked_screen.presentation.LikedFragment
import dagger.Component

@Component(dependencies = [CoreComponent::class],
    modules = [DatabaseModule::class, RepositoryModule::class, NetworkModule::class, MainActivityModule::class])
@Screen
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: SplashActivity)
    fun inject(fragment: HomeFragment)
    fun inject(applicationComponent: ApplicationComponent)
    fun inject(fragment: ProductDetailsFragment)
    fun inject(fragment: PDItemFragment)
    fun inject(fragment: MyCartFragment)
    fun inject(fragment: LikedFragment)
}