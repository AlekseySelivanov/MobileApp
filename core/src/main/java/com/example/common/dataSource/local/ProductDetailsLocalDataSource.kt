package com.example.common.dataSource.local

import com.example.common.dataSource.local.database.ProductDetailsItemDB

interface ProductDetailsLocalDataSource {

    suspend fun insertPDItemToCache(productDetailsItemDB: ProductDetailsItemDB)

    suspend fun getProductDetails(): List<ProductDetailsItemDB>
}