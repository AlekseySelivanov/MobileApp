package com.example.common.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(val app: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

}
