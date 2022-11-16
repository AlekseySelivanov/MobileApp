package com.example.product_details_screen.domain.usecase

import com.example.product_details_screen.domain.repository.ProductDetailsRepository
import javax.inject.Inject

class InsertProductDetailsToDBUseCase @Inject constructor(
    private val productDetailsRepository: ProductDetailsRepository
    ) {

    suspend fun insertProductDetailsToCache() {
        return productDetailsRepository.insertProductDetailsToCache()
    }
}