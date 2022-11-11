package com.example.common.repositories.liked_repositories

import androidx.lifecycle.LiveData
import com.example.common.models.likedModel.PhoneBookmark

interface BookmarkRepository {

    fun getBookmarks(): LiveData<List<PhoneBookmark>>

    suspend fun deleteBookmark(phoneBookmark: PhoneBookmark)

    suspend fun deleteAllBookmarks()
}

