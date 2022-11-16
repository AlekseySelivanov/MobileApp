package com.example.product_details_screen.data.dataSource.local

import com.example.product_details_screen.data.dataBase.model.ProductDetailsItemDB

interface ProductDetailsLocalDataSource {

    suspend fun insertPDItemToCache(productDetailsItemDB: ProductDetailsItemDB)

    suspend fun getProductDetails(): List<ProductDetailsItemDB>
}