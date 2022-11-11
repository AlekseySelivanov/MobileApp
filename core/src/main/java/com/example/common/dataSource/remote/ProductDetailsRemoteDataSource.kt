package com.example.common.dataSource.remote

import com.example.common.models.modelRemote.ProductDetailsItemRemote

interface ProductDetailsRemoteDataSource {

    suspend fun getPhonesDetailsList(): ProductDetailsItemRemote
}