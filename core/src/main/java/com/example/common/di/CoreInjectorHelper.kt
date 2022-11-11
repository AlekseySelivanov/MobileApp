package com.example.common.di

import android.content.Context

object CoreInjectorHelper {

    fun provideCoreComponent(applicationContext: Context): CoreComponent {
        return if (applicationContext is CoreComponentProvider) {
            (applicationContext as CoreComponentProvider).provideCoreComponent()
        } else {
            throw IllegalStateException("$applicationContext Provide the application context which implement CoreComponentProvider")
        }
    }
}