package com.example.cart_screen.di.modules

import android.content.Context
import androidx.room.Room
import com.example.common.constants.Constants.MY_CART_DATABASE_TABLE_NAME
import com.example.cart_screen.data.database.MyCartDao
import com.example.cart_screen.data.database.MyCartDatabase
import com.example.cart_screen.di.ModuleScope
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    @ModuleScope
    fun provideMyCartDatabase( context: Context): MyCartDatabase = Room
        .databaseBuilder(
            context,
            MyCartDatabase::class.java,
            MY_CART_DATABASE_TABLE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @ModuleScope
    fun provideMyCartDao(appDatabase: MyCartDatabase): MyCartDao = appDatabase.myCartDao()

}