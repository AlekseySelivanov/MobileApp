package com.example.common.repositories.product_details

import com.example.common.dataSource.local.ProductDetailsLocalDataSource
import com.example.common.dataSource.remote.ProductDetailsRemoteDataSource
import com.example.common.mapper.ProductDetailsMapper
import com.example.common.models.ProductDetailsItem
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