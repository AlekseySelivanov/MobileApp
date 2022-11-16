package com.example.cart_screen.data.datasource.local

import com.example.cart_screen.data.database.MyCartDao
import com.example.cart_screen.data.database.model.BasketMainDB
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