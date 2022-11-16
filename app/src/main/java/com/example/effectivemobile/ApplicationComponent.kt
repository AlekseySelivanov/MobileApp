package com.example.effectivemobile

import android.app.Application
import com.example.cart_screen.di.CartComponent
import com.example.cart_screen.di.CartComponentProvider
import com.example.cart_screen.di.DaggerCartComponent
import com.example.cart_screen.di.modules.CartModule
import com.example.home_screen.home_screen.di.modules.HomeModule
import com.example.common.di.*
import com.example.effectivemobile.di.DaggerAppComponent
import com.example.home_screen.home_screen.di.DaggerHomeScreenComponent
import com.example.home_screen.home_screen.di.HomeScreenComponent
import com.example.home_screen.home_screen.di.HomeScreenComponentProvider
import com.example.liked_screen.di.DaggerLikedScreenComponent
import com.example.liked_screen.di.LikedScreenComponent
import com.example.liked_screen.di.LikedScreenComponentProvider
import com.example.liked_screen.di.modules.LikedModule
import com.example.product_details_screen.di.DaggerProductDetailsScreenComponent
import com.example.product_details_screen.di.ProductDetailsScreenComponent
import com.example.product_details_screen.di.ProductScreenComponentProvider
import com.example.product_details_screen.di.module.ProductModule

class ApplicationComponent
    : Application(), CoreComponentProvider, CartComponentProvider, HomeScreenComponentProvider, LikedScreenComponentProvider, ProductScreenComponentProvider{

    private lateinit var coreComponent: CoreComponent
    private lateinit var cartComponent: CartComponent
    private lateinit var homeScreenComponent: HomeScreenComponent
    private lateinit var likedScreenComponent: LikedScreenComponent
    private lateinit var productDetailsScreenComponent: ProductDetailsScreenComponent

    override fun onCreate() {
        super.onCreate()
        initCoreComponent()
        initCartComponent()
        initHomeScreenComponent()
        initLikedScreenComponent()
        initProductDetailsScreenComponent()
    }

    private fun initCoreComponent() {
        coreComponent = DaggerCoreComponent
            .builder().coreModule(CoreModule(this))
            .build()
        val component =
            DaggerAppComponent.builder()
                .coreComponent(CoreInjectorHelper.provideCoreComponent(applicationContext))
                .build()
        component.inject(this)
    }

    private fun initCartComponent() {
        cartComponent = DaggerCartComponent
            .builder().cartModule(CartModule(this))
            .build()
        val component =
            DaggerAppComponent.builder()
                .coreComponent(CoreInjectorHelper.provideCoreComponent(applicationContext))
                .build()
        component.inject(this)
    }

    private fun initHomeScreenComponent() {
        homeScreenComponent = DaggerHomeScreenComponent
            .builder().homeModule(HomeModule(this))
            .build()
        val component =
            DaggerAppComponent.builder()
                .coreComponent(CoreInjectorHelper.provideCoreComponent(applicationContext))
                .build()
        component.inject(this)
    }

    private fun initLikedScreenComponent() {
        likedScreenComponent = DaggerLikedScreenComponent
            .builder().likedModule(LikedModule(this))
            .build()
        val component =
            DaggerAppComponent.builder()
                .coreComponent(CoreInjectorHelper.provideCoreComponent(applicationContext))
                .build()
        component.inject(this)
    }

    private fun initProductDetailsScreenComponent() {
        productDetailsScreenComponent = DaggerProductDetailsScreenComponent
            .builder().productModule(ProductModule(this))
            .build()
        val component =
            DaggerAppComponent.builder()
                .coreComponent(CoreInjectorHelper.provideCoreComponent(applicationContext))
                .build()
        component.inject(this)
    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            initCoreComponent()
        }
        return coreComponent
    }

    override fun provideCartComponent(): CartComponent {
        if (!this::cartComponent.isInitialized ) {
            initCartComponent()
        }
        return cartComponent
    }

    override fun provideHomeScreenComponent(): HomeScreenComponent {
        if (!this::homeScreenComponent.isInitialized ) {
            initHomeScreenComponent()
        }
        return homeScreenComponent
    }

    override fun provideLikedScreenComponent(): LikedScreenComponent {
        if (!this::likedScreenComponent.isInitialized ) {
            initLikedScreenComponent()
        }
        return likedScreenComponent
    }

    override fun provideProductDetailsScreenComponent(): ProductDetailsScreenComponent {
        if (!this::productDetailsScreenComponent.isInitialized ) {
            initProductDetailsScreenComponent()
        }
        return productDetailsScreenComponent
    }
}