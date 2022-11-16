package com.example.liked_screen.domain.repository

import androidx.lifecycle.LiveData
import com.example.liked_screen.domain.model.PhoneBookmark

interface BookmarkRepository {

    fun getBookmarks(): LiveData<List<PhoneBookmark>>

    suspend fun deleteBookmark(phoneBookmark: PhoneBookmark)

    suspend fun deleteAllBookmarks()
}

