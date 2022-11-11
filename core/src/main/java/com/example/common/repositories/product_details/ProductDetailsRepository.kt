package com.example.common.repositories.product_details

import com.example.common.models.ProductDetailsItem

interface ProductDetailsRepository {

    suspend fun getProductDetails(): ProductDetailsItem

    suspend fun insertProductDetailsToCache()
}