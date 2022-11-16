package com.example.home_screen.home_screen.domain.useCases

import com.example.home_screen.home_screen.domain.model.BestSeller
import com.example.home_screen.home_screen.domain.repository.MainRepository
import javax.inject.Inject

class DeleteBookmarkMainUseCase @Inject constructor(private val mainRepository: MainRepository) {

    suspend fun deleteBookmark(bestSeller: BestSeller) {
        mainRepository.deleteBookmark(bestSeller)
    }
}