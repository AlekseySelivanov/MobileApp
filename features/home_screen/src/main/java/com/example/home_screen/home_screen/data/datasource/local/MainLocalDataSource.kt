package com.example.home_screen.home_screen.data.datasource.local

import com.example.home_screen.home_screen.data.database.ModelDB.BestSellerDB
import com.example.home_screen.home_screen.data.database.ModelDB.HomeStoreDB
import com.example.home_screen.home_screen.data.database.ModelDB.MainDB
import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB

interface MainLocalDataSource {

    suspend fun addBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    suspend fun insertMainDBToDB(mainDB: MainDB)

    suspend fun getBestSellerDBPhonesList(): List<BestSellerDB>

    suspend fun getHomeStoreDBPhonesList(): List<HomeStoreDB>
}