package com.example.common.dataSource.remote

import com.example.common.models.modelRemote.ProductDetailsItemRemote
import com.example.common.dataSource.remote.network.ProductDetailsApiService
import javax.inject.Inject

class ProductDetailsRemoteDataSourceImpl @Inject constructor(
    private val productDetailsApiService: ProductDetailsApiService
    ) :
    ProductDetailsRemoteDataSource {

    override suspend fun getPhonesDetailsList(): ProductDetailsItemRemote {
        return productDetailsApiService.getProductDetails()
    }
}