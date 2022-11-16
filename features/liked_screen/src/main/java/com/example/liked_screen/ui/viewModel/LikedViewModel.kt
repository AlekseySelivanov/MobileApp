package com.example.liked_screen.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.liked_screen.domain.model.PhoneBookmark
import com.example.liked_screen.domain.usecase.GetBookmarksListUseCase
import com.example.liked_screen.domain.usecase.DeleteAllBookmarksUseCase
import com.example.liked_screen.domain.usecase.DeleteBookmarkUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LikedViewModel @Inject constructor(
    private val getBookmarksListUseCase: GetBookmarksListUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    private val deleteAllBookmarksUseCase: DeleteAllBookmarksUseCase
) : ViewModel() {

    val bookmarksList: Flow<List<PhoneBookmark>> = getBookmarksListUseCase.getBookmarksList().asFlow()

    fun deleteBookmark(phoneBookmark: PhoneBookmark) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteBookmarkUseCase.deleteBookmark(phoneBookmark)
        }
    }

    fun deleteAllBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllBookmarksUseCase.deleteAllBookmarks()
        }
    }
}