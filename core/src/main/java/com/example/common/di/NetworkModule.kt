package com.example.common.di

import com.example.common.constants.Constants.MAIN_API_BASE_URL
import com.example.common.dataSource.remote.network.MyCartApi
import com.example.common.dataSource.remote.network.MyCartApiService
import com.example.common.dataSource.remote.network.ProductDetailsApi
import com.example.common.dataSource.remote.network.ProductDetailsApiService
import com.example.common.network.MainApi
import com.example.common.network.MainApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .build()
    }

    @Provides
    fun moshiConverterFactory() = MoshiConverterFactory.create()

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(MAIN_API_BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiClient(apiService: Retrofit): MainApiService {
        return MainApi.retrofitService
    }

    @Provides
    fun provideProductApiClient(apiService: Retrofit): ProductDetailsApiService {
        return ProductDetailsApi.retrofitService
    }

    @Provides
    fun provideMyCartApiService(apiService: Retrofit): MyCartApiService {
        return MyCartApi.retrofitService
    }
}