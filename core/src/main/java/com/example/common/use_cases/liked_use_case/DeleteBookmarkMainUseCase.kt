package com.example.common.use_cases.liked_use_case

import com.example.common.models.BestSeller
import com.example.common.repositories.homeRepositories.MainRepository
import javax.inject.Inject

class DeleteBookmarkMainUseCase @Inject constructor(private val mainRepository: MainRepository) {

    suspend fun deleteBookmark(bestSeller: BestSeller) {
        mainRepository.deleteBookmark(bestSeller)
    }
}