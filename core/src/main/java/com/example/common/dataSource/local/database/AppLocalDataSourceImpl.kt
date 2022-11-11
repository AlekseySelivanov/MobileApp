package com.example.common.dataSource.local.database

import androidx.lifecycle.LiveData
import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB
import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import javax.inject.Inject

class AppLocalDataSourceImpl @Inject constructor(
    private val bookmarkDao: BookmarkDao
    ) : AppLocalDataSource {

    override fun getBookmarks(): LiveData<List<PhoneBookmarkDB>> {
        return bookmarkDao.getBookmarks()
    }
}