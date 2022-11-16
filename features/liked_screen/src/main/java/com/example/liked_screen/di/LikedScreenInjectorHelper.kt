package com.example.liked_screen.di

import android.content.Context

object LikedScreenInjectorHelper {

    fun provideLikedScreenComponent(applicationContext: Context): LikedScreenComponent {
        return if (applicationContext is LikedScreenComponentProvider) {
            (applicationContext as LikedScreenComponentProvider).provideLikedScreenComponent()
        } else {
            throw IllegalStateException("$applicationContext Provide the application context which implement CoreComponentProvider")
        }
    }
}