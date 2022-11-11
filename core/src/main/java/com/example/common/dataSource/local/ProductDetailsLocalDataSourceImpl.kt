package com.example.common.dataSource.local

import com.example.common.dataSource.local.database.ProductDetailsDao
import com.example.common.dataSource.local.database.ProductDetailsItemDB
import javax.inject.Inject

class ProductDetailsLocalDataSourceImpl @Inject constructor(
    private val productDetailsDao: ProductDetailsDao
    ) :
    ProductDetailsLocalDataSource {

    override suspend fun insertPDItemToCache(productDetailsItemDB: ProductDetailsItemDB) {
        productDetailsDao.insertProductDetails(productDetailsItemDB)
    }

    override suspend fun getProductDetails(): List<ProductDetailsItemDB> {
        return productDetailsDao.getProductDetails()
    }
}