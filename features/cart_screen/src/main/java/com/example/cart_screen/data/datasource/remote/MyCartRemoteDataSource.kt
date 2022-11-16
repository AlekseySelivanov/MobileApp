package com.example.cart_screen.data.datasource.remote

import com.example.cart_screen.data.network.model.BasketMainRemote

interface MyCartRemoteDataSource {

    suspend fun getMyCartFromServer(): BasketMainRemote
}