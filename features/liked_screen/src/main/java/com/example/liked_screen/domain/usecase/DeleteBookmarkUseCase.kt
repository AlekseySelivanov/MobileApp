package com.example.liked_screen.domain.usecase

import com.example.liked_screen.domain.model.PhoneBookmark
import com.example.liked_screen.domain.repository.BookmarkRepository
import javax.inject.Inject

class DeleteBookmarkUseCase @Inject constructor(private val bookmarkRepository: BookmarkRepository) {

    suspend fun deleteBookmark(phoneBookmark: PhoneBookmark) {
        bookmarkRepository.deleteBookmark(phoneBookmark)
    }
}