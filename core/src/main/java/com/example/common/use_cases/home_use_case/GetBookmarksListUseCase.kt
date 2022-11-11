package com.example.common.use_cases.home_use_case

import androidx.lifecycle.LiveData
import com.example.common.models.home_model.PhoneBookmark
import com.example.common.repositories.homeRepositories.AppRepository
import javax.inject.Inject

class GetBookmarksListUseCase @Inject constructor(
    private val appRepository: AppRepository
    ) {

    fun getBookmarksList(): LiveData<List<PhoneBookmark>> {
        return appRepository.getBookmarks()
    }
}