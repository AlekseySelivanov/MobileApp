package com.example.common.dataSource.remote

import com.example.common.dataSource.remote.network.MyCartApiService
import com.example.common.models.modelCart.BasketMainRemote
import javax.inject.Inject

class MyCartRemoteDataSourceImpl @Inject constructor(
    private val myCartApiService: MyCartApiService
    ) :
    MyCartRemoteDataSource {

    override suspend fun getMyCartFromServer(): BasketMainRemote {
        return myCartApiService.getMyCart()
    }
}