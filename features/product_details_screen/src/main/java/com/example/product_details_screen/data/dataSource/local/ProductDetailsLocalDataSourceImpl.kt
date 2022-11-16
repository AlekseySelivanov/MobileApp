package com.example.product_details_screen.data.dataSource.local

import com.example.product_details_screen.data.dataBase.ProductDetailsDao
import com.example.product_details_screen.data.dataBase.model.ProductDetailsItemDB
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