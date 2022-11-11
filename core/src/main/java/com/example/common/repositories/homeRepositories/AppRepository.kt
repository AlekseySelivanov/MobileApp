package com.example.common.repositories.homeRepositories

import androidx.lifecycle.LiveData
import com.example.common.models.home_model.PhoneBookmark

interface AppRepository {

    fun getBookmarks(): LiveData<List<PhoneBookmark>>
}

