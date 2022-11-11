package com.example.common.dataSource.local

import com.example.common.models.modelDB.BestSellerDB
import com.example.common.models.modelDB.HomeStoreDB
import com.example.common.dataSource.local.database.MainDB
import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB

interface MainLocalDataSource {

    suspend fun addBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    suspend fun insertMainDBToDB(mainDB: MainDB)

    suspend fun getBestSellerDBPhonesList(): List<BestSellerDB>

    suspend fun getHomeStoreDBPhonesList(): List<HomeStoreDB>
}