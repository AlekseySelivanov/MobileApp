package com.example.common.use_cases.liked_use_case

import androidx.lifecycle.LiveData
import com.example.common.models.likedModel.PhoneBookmark
import com.example.common.repositories.liked_repositories.BookmarkRepository
import javax.inject.Inject

class GetBookmarksListUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
    ) {

    fun getBookmarksList(): LiveData<List<PhoneBookmark>> {
        return bookmarkRepository.getBookmarks()
    }
}