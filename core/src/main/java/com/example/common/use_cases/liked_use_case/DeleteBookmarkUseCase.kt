package com.example.common.use_cases.liked_use_case

import com.example.common.models.likedModel.PhoneBookmark
import com.example.common.repositories.liked_repositories.BookmarkRepository
import javax.inject.Inject

class DeleteBookmarkUseCase @Inject constructor(private val bookmarkRepository: BookmarkRepository) {

    suspend fun deleteBookmark(phoneBookmark: PhoneBookmark) {
        bookmarkRepository.deleteBookmark(phoneBookmark)
    }
}