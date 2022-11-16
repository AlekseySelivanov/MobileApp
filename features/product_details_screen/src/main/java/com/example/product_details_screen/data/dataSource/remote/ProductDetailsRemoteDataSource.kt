package com.example.product_details_screen.data.dataSource.remote

import com.example.product_details_screen.data.network.model.ProductDetailsItemRemote

interface ProductDetailsRemoteDataSource {

    suspend fun getPhonesDetailsList(): ProductDetailsItemRemote
}