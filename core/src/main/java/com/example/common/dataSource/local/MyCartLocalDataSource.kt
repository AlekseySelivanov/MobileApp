package com.example.common.dataSource.local

import com.example.common.dataSource.local.database.BasketMainDB

interface MyCartLocalDataSource {

    suspend fun insertMyCartToDB(basketMainDB: BasketMainDB)

    suspend fun getMyCart(): List<BasketMainDB>
}