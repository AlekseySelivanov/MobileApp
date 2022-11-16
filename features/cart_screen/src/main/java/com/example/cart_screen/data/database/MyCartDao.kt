package com.example.cart_screen.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cart_screen.data.database.model.BasketMainDB

@Dao
interface MyCartDao {

    @Query("SELECT * FROM my_cart_cache ORDER BY id")
    suspend fun getMyCart(): List<BasketMainDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyCart(basketMainDB: BasketMainDB)
}