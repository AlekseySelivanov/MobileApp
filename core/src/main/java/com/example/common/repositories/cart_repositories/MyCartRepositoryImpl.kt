package com.example.common.repositories.cart_repositories

import com.example.common.dataSource.local.MyCartLocalDataSource
import com.example.common.dataSource.remote.MyCartRemoteDataSource
import com.example.common.mapper.MyCartMapper
import com.example.common.models.modelCart.BasketMain
import javax.inject.Inject

class MyCartRepositoryImpl @Inject constructor(
    private val myCartRemoteDataSource: MyCartRemoteDataSource,
    private val myCartMapper: MyCartMapper,
    private val myCartLocalDataSource: MyCartLocalDataSource
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