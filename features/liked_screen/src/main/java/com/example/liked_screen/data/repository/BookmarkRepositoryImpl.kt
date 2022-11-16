package com.example.liked_screen.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.liked_screen.data.dataSource.local.BookmarkLocalDataSource
import com.example.liked_screen.data.mapper.BookmarkMapper
import com.example.liked_screen.domain.model.PhoneBookmark
import com.example.liked_screen.domain.repository.BookmarkRepository
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val bookmarkLocalDataSource: BookmarkLocalDataSource,
    private val bookmarkMapper: BookmarkMapper
) : BookmarkRepository {

    override fun getBookmarks(): LiveData<List<PhoneBookmark>> =
        Transformations.map(bookmarkLocalDataSource.getBookmarks()) {
            bookmarkMapper.mapListBookmarkDBToListBookmark(it)
        }

    override suspend fun deleteBookmark(phoneBookmark: PhoneBookmark) {
        bookmarkLocalDataSource.deleteBookmark(
            bookmarkMapper.mapBookmarkToPhoneBookmarkDB(
                phoneBookmark
            )
        )
    }

    override suspend fun deleteAllBookmarks() {
        bookmarkLocalDataSource.deleteAllBookmarks()
    }
}