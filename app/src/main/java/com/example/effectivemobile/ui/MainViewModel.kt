package com.example.effectivemobile.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import com.example.common.models.likedModel.PhoneBookmark
import com.example.common.use_cases.home_use_case.GetBookmarksListUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MainViewModel @Inject constructor(
    getBookmarksListUseCase: GetBookmarksListUseCase
    ): ViewModel() {

    val bookmarksList: Flow<List<PhoneBookmark>> = getBookmarksListUseCase.getBookmarksList().asFlow()
}