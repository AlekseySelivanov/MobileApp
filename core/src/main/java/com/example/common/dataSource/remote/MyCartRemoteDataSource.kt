package com.example.common.dataSource.remote

import com.example.common.models.modelCart.BasketMainRemote

interface MyCartRemoteDataSource {

    suspend fun getMyCartFromServer(): BasketMainRemote
}