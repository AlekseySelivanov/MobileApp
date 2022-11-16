package com.example.common.repositories.homeRepositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.common.dataSource.local.database.AppLocalDataSource
import com.example.common.mapper.AppMapper
import com.example.common.models.likedModel.PhoneBookmark

import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val appLocalDataSource: AppLocalDataSource,
    private val appMapper: AppMapper
) : AppRepository {

    override fun getBookmarks(): LiveData<List<PhoneBookmark>> =
        Transformations.map(appLocalDataSource.getBookmarks()) {
            appMapper.mapListPhoneBookmarkDBToListPhoneBookmark(it)
        }
}