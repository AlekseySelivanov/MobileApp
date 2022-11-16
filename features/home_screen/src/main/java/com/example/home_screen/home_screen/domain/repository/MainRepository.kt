package com.example.home_screen.home_screen.domain.repository

import com.example.home_screen.home_screen.domain.model.BestSeller
import com.example.home_screen.home_screen.domain.model.HomeStore

interface MainRepository {

    suspend fun getBestSellerPhonesList(): List<BestSeller>

    suspend fun getHomeStorePhonesList(): List<HomeStore>

    suspend fun addBookmark(bestSeller: BestSeller)

    suspend fun deleteBookmark(bestSeller: BestSeller)

    suspend fun insertMainRemoteToDB()
}