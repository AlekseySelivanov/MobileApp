package com.example.product_details_screen.domain.repository

import com.example.product_details_screen.domain.model.ProductDetailsItem

interface ProductDetailsRepository {

    suspend fun getProductDetails(): ProductDetailsItem

    suspend fun insertProductDetailsToCache()
}