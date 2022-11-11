package com.example.common.repositories.liked_repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.common.dataSource.local.liked_screen.BookmarkLocalDataSource
import com.example.common.mapper.BookmarkMapper
import com.example.common.models.likedModel.PhoneBookmark
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