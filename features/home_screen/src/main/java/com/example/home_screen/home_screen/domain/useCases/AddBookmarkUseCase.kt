package com.example.home_screen.home_screen.domain.useCases

import com.example.home_screen.home_screen.domain.model.BestSeller
import com.example.home_screen.home_screen.domain.repository.MainRepository
import javax.inject.Inject

class AddBookmarkUseCase @Inject constructor(private val mainRepository: MainRepository) {

    suspend fun addBookmark(bestSeller: BestSeller) {
        mainRepository.addBookmark(bestSeller)
    }
}