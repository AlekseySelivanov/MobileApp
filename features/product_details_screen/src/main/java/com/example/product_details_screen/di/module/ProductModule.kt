package com.example.product_details_screen.di.module

import android.app.Application
import android.content.Context
import com.example.product_details_screen.di.ModuleScope
import dagger.Module
import dagger.Provides

@Module
class ProductModule(val app: Application) {
    @Provides
    @ModuleScope
    fun provideContext(): Context = app

}
