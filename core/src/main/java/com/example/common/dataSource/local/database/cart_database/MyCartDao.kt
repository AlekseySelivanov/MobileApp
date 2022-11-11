package com.example.common.dataSource.local.database.cart_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.common.dataSource.local.database.BasketMainDB

@Dao
interface MyCartDao {

    @Query("SELECT * FROM my_cart_cache ORDER BY id")
    suspend fun getMyCart(): List<BasketMainDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyCart(basketMainDB: BasketMainDB)
}