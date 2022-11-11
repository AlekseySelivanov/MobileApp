package com.example.common.dataSource.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDetailsDao {

    @Query("SELECT * FROM product_details_cache ORDER BY id")
    suspend fun getProductDetails(): List<ProductDetailsItemDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductDetails(productDetailsItemDB: ProductDetailsItemDB)
}