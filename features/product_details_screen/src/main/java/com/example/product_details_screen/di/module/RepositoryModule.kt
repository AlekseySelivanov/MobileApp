package com.example.product_details_screen.di.module

import com.example.product_details_screen.data.dataBase.ProductDetailsDao
import com.example.product_details_screen.data.dataSource.local.ProductDetailsLocalDataSource
import com.example.product_details_screen.data.dataSource.local.ProductDetailsLocalDataSourceImpl
import com.example.product_details_screen.data.dataSource.remote.ProductDetailsRemoteDataSource
import com.example.product_details_screen.data.dataSource.remote.ProductDetailsRemoteDataSourceImpl
import com.example.product_details_screen.data.mapper.ProductDetailsMapper
import com.example.product_details_screen.data.network.ProductDetailsApiService
import com.example.product_details_screen.data.repository.ProductDetailsRepositoryImpl
import com.example.product_details_screen.domain.repository.ProductDetailsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideProductDetailsRepository(
        productDetailsRemoteDataSource: ProductDetailsRemoteDataSource,
        productDetailsMapper: ProductDetailsMapper,
        productDetailsLocalDataSource: ProductDetailsLocalDataSource
    ): ProductDetailsRepository =
        ProductDetailsRepositoryImpl(
            productDetailsRemoteDataSource,
            productDetailsMapper,
            productDetailsLocalDataSource
        )

    @Provides
    fun productDetailsRemoteDataSource(
        productDetailsApiService: ProductDetailsApiService
    ): ProductDetailsRemoteDataSource =
        ProductDetailsRemoteDataSourceImpl(
            productDetailsApiService
        )

    @Provides
    fun productDetailsLocalDataSource(
        productDetailsDao: ProductDetailsDao
    ): ProductDetailsLocalDataSource =
        ProductDetailsLocalDataSourceImpl(
            productDetailsDao
        )


}