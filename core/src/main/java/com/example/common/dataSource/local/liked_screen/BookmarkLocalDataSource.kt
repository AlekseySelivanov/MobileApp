package com.example.common.dataSource.local.liked_screen

import androidx.lifecycle.LiveData
import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB

interface BookmarkLocalDataSource {

    fun getBookmarks(): LiveData<List<PhoneBookmarkDB>>

    suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    suspend fun deleteAllBookmarks()
}