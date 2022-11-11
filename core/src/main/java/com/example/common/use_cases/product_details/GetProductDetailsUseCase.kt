package com.example.common.use_cases.product_details

import com.example.common.models.ProductDetailsItem
import com.example.common.repositories.product_details.ProductDetailsRepository
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val productDetailsRepository: ProductDetailsRepository
    ) {

    suspend fun getProductDetails(): ProductDetailsItem {
        return productDetailsRepository.getProductDetails()
    }
}