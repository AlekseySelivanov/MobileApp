package com.example.home_screen.home_screen.di

import android.content.Context

object HomeScreenInjectorHelper {

    fun provideHomeScreenComponent(applicationContext: Context): HomeScreenComponent {
        return if (applicationContext is HomeScreenComponentProvider) {
            (applicationContext as HomeScreenComponentProvider).provideHomeScreenComponent()
        } else {
            throw IllegalStateException("$applicationContext Provide the application context which implement CoreComponentProvider")
        }
    }
}