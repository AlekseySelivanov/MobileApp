package com.example.common.dataSource.remote.network

import com.example.common.constants.Constants.PRODUCT_DETAILS_BASE_URL
import com.example.common.constants.Constants.PRODUCT_DETAILS_GET
import com.example.common.models.modelRemote.ProductDetailsItemRemote
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(PRODUCT_DETAILS_BASE_URL)
    .build()

interface ProductDetailsApiService {
    @GET(PRODUCT_DETAILS_GET)
    suspend fun getProductDetails(): ProductDetailsItemRemote
}

object ProductDetailsApi {
    val retrofitService: ProductDetailsApiService by lazy {
        retrofit.create(ProductDetailsApiService::class.java)
    }
}