package com.example.liked_screen.domain.usecase

import androidx.lifecycle.LiveData
import com.example.liked_screen.domain.model.PhoneBookmark
import com.example.liked_screen.domain.repository.BookmarkRepository
import javax.inject.Inject

class GetBookmarksListUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
    ) {

    fun getBookmarksList(): LiveData<List<PhoneBookmark>> {
        return bookmarkRepository.getBookmarks()
    }
}