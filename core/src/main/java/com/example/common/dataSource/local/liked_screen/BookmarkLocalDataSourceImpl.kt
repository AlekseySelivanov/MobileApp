package com.example.common.dataSource.local.liked_screen

import androidx.lifecycle.LiveData
import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB
import javax.inject.Inject

class BookmarkLocalDataSourceImpl @Inject constructor(
    private val bookmarkDao: BookmarkDao
    ) : BookmarkLocalDataSource {

    override fun getBookmarks(): LiveData<List<PhoneBookmarkDB>> {
        return bookmarkDao.getBookmarks()
    }

    override suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB) {
        bookmarkDao.deleteBookmark(phoneBookmarkDB)
    }

    override suspend fun deleteAllBookmarks() {
        bookmarkDao.deleteAllBookmarks()
    }
}