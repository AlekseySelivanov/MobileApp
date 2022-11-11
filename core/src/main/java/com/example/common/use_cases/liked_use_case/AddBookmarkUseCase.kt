package com.example.common.use_cases.liked_use_case

import com.example.common.models.BestSeller
import com.example.common.repositories.homeRepositories.MainRepository
import javax.inject.Inject

class AddBookmarkUseCase @Inject constructor(private val mainRepository: MainRepository) {

    suspend fun addBookmark(bestSeller: BestSeller) {
        mainRepository.addBookmark(bestSeller)
    }
}