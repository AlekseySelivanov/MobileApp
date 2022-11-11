package com.example.common.di

import android.content.Context
import androidx.room.Room
import com.example.common.constants.Constants.BOOKMARK_DATABASE_NAME
import com.example.common.constants.Constants.MAIN_SCREEN_DATABASE_NAME
import com.example.common.constants.Constants.MY_CART_DATABASE_TABLE_NAME
import com.example.common.constants.Constants.PRODUCT_DETAILS_DATABASE_TABLE_NAME
import com.example.common.dataSource.local.database.ProductDetailsDao
import com.example.common.dataSource.local.database.ProductDetailsDatabase
import com.example.common.dataSource.local.database.cart_database.MyCartDao
import com.example.common.dataSource.local.database.cart_database.MyCartDatabase
import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import com.example.common.dataSource.local.database.liked_database.BookmarkDatabase
import com.example.common.mainScreenDataBase.MainScreenDao
import com.example.common.mainScreenDataBase.MainScreenDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase( context: Context): MainScreenDatabase = Room
        .databaseBuilder(
            context,
            MainScreenDatabase::class.java,
            MAIN_SCREEN_DATABASE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()


    @Provides
    @Singleton
    fun provideMainScreenDao(appDatabase: MainScreenDatabase): MainScreenDao = appDatabase.mainScreenDao()


    @Provides
    @Singleton
    fun provideProductsDatabase( context: Context): ProductDetailsDatabase = Room
        .databaseBuilder(
            context,
            ProductDetailsDatabase::class.java,
            PRODUCT_DETAILS_DATABASE_TABLE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideProductsDao(appDatabase: ProductDetailsDatabase): ProductDetailsDao = appDatabase.productDetailsDao()

    @Provides
    @Singleton
    fun provideMyCartDatabase( context: Context): MyCartDatabase = Room
        .databaseBuilder(
            context,
            MyCartDatabase::class.java,
            MY_CART_DATABASE_TABLE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideMyCartDao(appDatabase: MyCartDatabase): MyCartDao = appDatabase.myCartDao()

    @Provides
    @Singleton
    fun provideBookmarkDatabase( context: Context): BookmarkDatabase = Room
        .databaseBuilder(
            context,
            BookmarkDatabase::class.java,
            BOOKMARK_DATABASE_NAME

        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideBookmarkDao(appDatabase: BookmarkDatabase): BookmarkDao = appDatabase.bookmarkDao()

}