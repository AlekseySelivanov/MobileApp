package com.example.home_screen.home_screen.di.modules

import com.example.common.constants.Constants.MAIN_API_BASE_URL
import com.example.home_screen.home_screen.data.network.MainApi
import com.example.home_screen.home_screen.data.network.MainApiService
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
}