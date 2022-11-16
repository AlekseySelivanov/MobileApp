package com.example.product_details_screen.di

import android.content.Context
import com.example.product_details_screen.data.dataSource.local.ProductDetailsLocalDataSource
import com.example.product_details_screen.data.dataSource.remote.ProductDetailsRemoteDataSource
import com.example.product_details_screen.data.mapper.ProductDetailsMapper
import com.example.product_details_screen.di.module.DatabaseModule
import com.example.product_details_screen.di.module.NetworkModule
import com.example.product_details_screen.di.module.ProductModule
import com.example.product_details_screen.di.module.RepositoryModule
import com.example.product_details_screen.domain.repository.ProductDetailsRepository
import dagger.Component

@ModuleScope
@Component(
    modules = [ProductModule::class, DatabaseModule::class, RepositoryModule::class, NetworkModule::class]
)
interface ProductDetailsScreenComponent {
    fun appContext(): Context

    fun productDetailsRepository(): ProductDetailsRepository
    fun productDetailsRemoteDataSource(): ProductDetailsRemoteDataSource
    fun productDetailsLocalDataSource(): ProductDetailsLocalDataSource
    fun productDetailsMapper(): ProductDetailsMapper

}