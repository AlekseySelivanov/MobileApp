package com.example.effectivemobile.di

import com.example.cart_screen.ui.MyCartFragment
import com.example.common.di.*
import com.example.effectivemobile.ApplicationComponent
import com.example.effectivemobile.di.mainActivity.MainActivityModule
import com.example.effectivemobile.ui.MainActivity
import com.example.effectivemobile.ui.splash_screen.SplashActivity
import com.example.home_screen.home_screen.di.modules.DatabaseModule
import com.example.home_screen.home_screen.ui.HomeFragment
import com.example.liked_screen.ui.LikedFragment
import com.example.product_details_screen.ui.PDItemFragment
import com.example.product_details_screen.ui.ProductDetailsFragment
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [DatabaseModule::class, MainActivityModule::class])
@MainScope
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