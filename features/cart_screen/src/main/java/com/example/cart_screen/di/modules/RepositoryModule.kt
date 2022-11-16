package com.example.cart_screen.di.modules

import com.example.cart_screen.data.database.MyCartDao
import com.example.cart_screen.data.datasource.local.MyCartLocalDataSource
import com.example.cart_screen.data.datasource.local.MyCartLocalDataSourceImpl
import com.example.cart_screen.data.datasource.remote.MyCartRemoteDataSource
import com.example.cart_screen.data.datasource.remote.MyCartRemoteDataSourceImpl
import com.example.cart_screen.data.mapper.MyCartMapper
import com.example.cart_screen.data.network.MyCartApiService
import com.example.cart_screen.data.repository.MyCartRepositoryImpl
import com.example.cart_screen.domain.repository.MyCartRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideMyCartRepository(
        myCartRemoteDataSource: MyCartRemoteDataSource,
        myCartMapper: MyCartMapper,
        myCartLocalDataSource: MyCartLocalDataSource
    ): MyCartRepository = MyCartRepositoryImpl(
        myCartRemoteDataSource,
        myCartMapper,
        myCartLocalDataSource
    )

    @Provides
    fun productMyCartRemoteDataSource(
        myCartApiService: MyCartApiService
    ): MyCartRemoteDataSource =
        MyCartRemoteDataSourceImpl(myCartApiService)

    @Provides
    fun productMyCartLocalDataSource(
        myCartDao: MyCartDao
    ): MyCartLocalDataSource =
        MyCartLocalDataSourceImpl(myCartDao)
}