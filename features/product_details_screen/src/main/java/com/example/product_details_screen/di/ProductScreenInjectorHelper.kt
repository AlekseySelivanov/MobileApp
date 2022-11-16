package com.example.product_details_screen.di

import android.content.Context

object ProductScreenInjectorHelper {

    fun provideProductDetailsScreenComponent(applicationContext: Context): ProductDetailsScreenComponent {
        return if (applicationContext is ProductScreenComponentProvider) {
            (applicationContext as ProductScreenComponentProvider).provideProductDetailsScreenComponent()
        } else {
            throw IllegalStateException("$applicationContext Provide the application context which implement CoreComponentProvider")
        }
    }
}