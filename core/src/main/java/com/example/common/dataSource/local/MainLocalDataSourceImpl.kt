package com.example.common.dataSource.local

import com.example.common.mainScreenDataBase.MainScreenDao
import com.example.common.models.modelDB.BestSellerDB
import com.example.common.models.modelDB.HomeStoreDB
import com.example.common.dataSource.local.database.MainDB
import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB

import javax.inject.Inject

class MainLocalDataSourceImpl @Inject constructor(
    private val bookmarkDao: BookmarkDao,
    private val mainScreenDao: MainScreenDao
) : MainLocalDataSource {

    override suspend fun addBookmark(phoneBookmarkDB: PhoneBookmarkDB) {
        bookmarkDao.addBookmark(phoneBookmarkDB)
    }

    override suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB) {
        bookmarkDao.deleteBookmark(phoneBookmarkDB)
    }

    override suspend fun insertMainDBToDB(mainDB: MainDB) {
        mainScreenDao.insertMainDB(mainDB)
    }

    override suspend fun getBestSellerDBPhonesList(): List<BestSellerDB> {
        return mainScreenDao.getListMainDB()[0].bestSeller
    }

    override suspend fun getHomeStoreDBPhonesList(): List<HomeStoreDB> {
        return mainScreenDao.getListMainDB()[0].homeStore
    }

}