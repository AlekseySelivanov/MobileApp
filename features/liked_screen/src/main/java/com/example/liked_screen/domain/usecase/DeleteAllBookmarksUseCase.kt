package com.example.liked_screen.domain.usecase

import com.example.liked_screen.domain.repository.BookmarkRepository
import javax.inject.Inject

class DeleteAllBookmarksUseCase @Inject constructor(private val bookmarkRepository: BookmarkRepository) {

    suspend fun deleteAllBookmarks() {
        bookmarkRepository.deleteAllBookmarks()
    }
}