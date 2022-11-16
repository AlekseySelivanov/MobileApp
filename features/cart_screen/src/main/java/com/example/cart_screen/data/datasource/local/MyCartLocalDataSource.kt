package com.example.cart_screen.data.datasource.local

import com.example.cart_screen.data.database.model.BasketMainDB

interface MyCartLocalDataSource {

    suspend fun insertMyCartToDB(basketMainDB: BasketMainDB)

    suspend fun getMyCart(): List<BasketMainDB>
}