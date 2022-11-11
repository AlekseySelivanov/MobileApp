package com.example.common.use_cases.product_details

import com.example.common.repositories.product_details.ProductDetailsRepository
import javax.inject.Inject

class InsertProductDetailsToDBUseCase @Inject constructor(
    private val productDetailsRepository: ProductDetailsRepository
    ) {

    suspend fun insertProductDetailsToCache() {
        return productDetailsRepository.insertProductDetailsToCache()
    }
}