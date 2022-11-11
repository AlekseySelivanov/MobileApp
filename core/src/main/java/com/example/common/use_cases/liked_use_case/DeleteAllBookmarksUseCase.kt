package com.example.common.use_cases.liked_use_case

import com.example.common.repositories.liked_repositories.BookmarkRepository
import javax.inject.Inject

class DeleteAllBookmarksUseCase @Inject constructor(private val bookmarkRepository: BookmarkRepository) {

    suspend fun deleteAllBookmarks() {
        bookmarkRepository.deleteAllBookmarks()
    }
}