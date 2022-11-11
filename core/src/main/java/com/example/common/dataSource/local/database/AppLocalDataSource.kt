package com.example.common.dataSource.local.database

import androidx.lifecycle.LiveData
import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB

interface AppLocalDataSource {

    fun getBookmarks(): LiveData<List<PhoneBookmarkDB>>
}