package com.example.product_details_screen.data.repository

import com.example.product_details_screen.data.dataSource.local.ProductDetailsLocalDataSource
import com.example.product_details_screen.data.dataSource.remote.ProductDetailsRemoteDataSource
import com.example.product_details_screen.data.mapper.ProductDetailsMapper
import com.example.product_details_screen.domain.model.ProductDetailsItem
import com.example.product_details_screen.domain.repository.ProductDetailsRepository
import javax.inject.Inject

class ProductDetailsRepositoryImpl @Inject constructor(
    private val productDetailsRemoteDataSource: ProductDetailsRemoteDataSource,
    private val productDetailsMapper: ProductDetailsMapper,
    private val productDetailsLocalDataSource: ProductDetailsLocalDataSource
) :
    ProductDetailsRepository {

    override suspend fun getProductDetails(): ProductDetailsItem {
        return productDetailsMapper.mapProductDetailsItemDBToProductDetailsItem(
            productDetailsLocalDataSource.getProductDetails()[0]
        )
    }

    override suspend fun insertProductDetailsToCache() {
        val productDetailsItemRemote = productDetailsRemoteDataSource.getPhonesDetailsList()
        productDetailsLocalDataSource.insertPDItemToCache(
            productDetailsMapper.mapProductDetailsItemRemoteToProductDetailsItemDB(
                productDetailsItemRemote
            )
        )
    }
}