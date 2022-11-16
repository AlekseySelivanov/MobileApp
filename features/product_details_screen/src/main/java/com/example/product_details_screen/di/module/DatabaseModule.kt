package com.example.product_details_screen.di.module

import android.content.Context
import androidx.room.Room
import com.example.common.constants.Constants
import com.example.product_details_screen.data.dataBase.ProductDetailsDao
import com.example.product_details_screen.data.dataBase.ProductDetailsDatabase
import com.example.product_details_screen.di.ModuleScope
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    @ModuleScope
    fun provideProductsDatabase( context: Context): ProductDetailsDatabase = Room
        .databaseBuilder(
            context,
            ProductDetailsDatabase::class.java,
            Constants.PRODUCT_DETAILS_DATABASE_TABLE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @ModuleScope
    fun provideProductsDao(appDatabase: ProductDetailsDatabase): ProductDetailsDao = appDatabase.productDetailsDao()

}