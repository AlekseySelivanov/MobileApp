package com.example.product_details_screen.domain.usecase

import com.example.product_details_screen.domain.model.ProductDetailsItem
import com.example.product_details_screen.domain.repository.ProductDetailsRepository
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val productDetailsRepository: ProductDetailsRepository
    ) {

    suspend fun getProductDetails(): ProductDetailsItem {
        return productDetailsRepository.getProductDetails()
    }
}