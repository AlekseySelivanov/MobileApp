package com.example.cart_screen.data.datasource.remote

import com.example.cart_screen.data.network.MyCartApiService
import com.example.cart_screen.data.network.model.BasketMainRemote
import javax.inject.Inject

class MyCartRemoteDataSourceImpl @Inject constructor(
    private val myCartApiService: MyCartApiService
    ) :
    MyCartRemoteDataSource {

    override suspend fun getMyCartFromServer(): BasketMainRemote {
        return myCartApiService.getMyCart()
    }
}