package com.example.common.repositories.homeRepositories

import com.example.common.models.BestSeller
import com.example.common.models.home_model.HomeStore

interface MainRepository {

    suspend fun getBestSellerPhonesList(): List<BestSeller>

    suspend fun getHomeStorePhonesList(): List<HomeStore>

    suspend fun addBookmark(bestSeller: BestSeller)

    suspend fun deleteBookmark(bestSeller: BestSeller)

    suspend fun insertMainRemoteToDB()
}