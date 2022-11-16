package com.example.product_details_screen.data.dataSource.remote

import com.example.product_details_screen.data.network.ProductDetailsApiService
import com.example.product_details_screen.data.network.model.ProductDetailsItemRemote
import javax.inject.Inject

class ProductDetailsRemoteDataSourceImpl @Inject constructor(
    private val productDetailsApiService: ProductDetailsApiService
    ) :
    ProductDetailsRemoteDataSource {

    override suspend fun getPhonesDetailsList(): ProductDetailsItemRemote {
        return productDetailsApiService.getProductDetails()
    }
}