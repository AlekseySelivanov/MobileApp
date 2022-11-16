package com.example.cart_screen.di

import android.content.Context

object CartInjectorHelper {

    fun provideCartComponent(applicationContext: Context): CartComponent {
        return if (applicationContext is CartComponentProvider) {
            (applicationContext as CartComponentProvider).provideCartComponent()
        } else {
            throw IllegalStateException("$applicationContext Provide the application context which implement CoreComponentProvider")
        }
    }
}