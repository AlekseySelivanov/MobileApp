package com.example.home_screen.home_screen.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HomeModule(val app: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

}
