package com.example.cart_screen.di.modules

import android.app.Application
import android.content.Context
import com.example.cart_screen.di.ModuleScope
import dagger.Module
import dagger.Provides

@Module
class CartModule(val app: Application) {
    @Provides
    @ModuleScope
    fun provideContext(): Context = app

}