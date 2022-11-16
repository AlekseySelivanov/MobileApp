package com.example.common.repositories.homeRepositories

import androidx.lifecycle.LiveData
import com.example.common.models.likedModel.PhoneBookmark

interface AppRepository {

    fun getBookmarks(): LiveData<List<PhoneBookmark>>
}