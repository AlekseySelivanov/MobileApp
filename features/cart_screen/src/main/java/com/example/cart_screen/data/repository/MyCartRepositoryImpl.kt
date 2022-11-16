package com.example.cart_screen.data.repository

import com.example.cart_screen.domain.model.BasketMain
import com.example.cart_screen.domain.repository.MyCartRepository
import javax.inject.Inject

class MyCartRepositoryImpl @Inject constructor(
    private val myCartRemoteDataSource: com.example.cart_screen.data.datasource.remote.MyCartRemoteDataSource,
    private val myCartMapper: com.example.cart_screen.data.mapper.MyCartMapper,
    private val myCartLocalDataSource: com.example.cart_screen.data.datasource.local.MyCartLocalDataSource
) : MyCartRepository {

    override suspend fun getMyCart(): BasketMain {
        val listBasketMain =
            myCartMapper.mapListBasketMainDBToListBasketMain(myCartLocalDataSource.getMyCart())
        return listBasketMain[0]
    }

    override suspend fun insertMyCartToDB() {
        val basketMainRemote = myCartRemoteDataSource.getMyCartFromServer()
        myCartLocalDataSource.insertMyCartToDB(
            myCartMapper.mapBasketMainRemoteToBasketMainDB(
                basketMainRemote
            )
        )
    }
}