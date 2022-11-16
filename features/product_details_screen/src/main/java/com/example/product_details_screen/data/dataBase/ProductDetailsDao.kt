package com.example.product_details_screen.data.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.product_details_screen.data.dataBase.model.ProductDetailsItemDB

@Dao
interface ProductDetailsDao {

    @Query("SELECT * FROM product_details_cache ORDER BY id")
    suspend fun getProductDetails(): List<ProductDetailsItemDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductDetails(productDetailsItemDB: ProductDetailsItemDB)
}