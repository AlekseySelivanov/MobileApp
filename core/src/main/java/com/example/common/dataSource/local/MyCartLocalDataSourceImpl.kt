package com.example.common.dataSource.local

import com.example.common.dataSource.local.database.cart_database.MyCartDao
import com.example.common.dataSource.local.database.BasketMainDB
import javax.inject.Inject

class MyCartLocalDataSourceImpl @Inject constructor(
    private val myCartDao: MyCartDao
    ) :
    MyCartLocalDataSource {

    override suspend fun insertMyCartToDB(basketMainDB: BasketMainDB) {
        myCartDao.insertMyCart(basketMainDB)
    }

    override suspend fun getMyCart(): List<BasketMainDB> {
        return myCartDao.getMyCart()
    }
}