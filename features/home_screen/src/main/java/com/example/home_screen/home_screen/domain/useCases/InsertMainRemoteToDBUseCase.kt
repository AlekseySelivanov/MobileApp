package com.example.home_screen.home_screen.domain.useCases

import com.example.home_screen.home_screen.domain.repository.MainRepository
import javax.inject.Inject

class InsertMainRemoteToDBUseCase @Inject constructor (
    private val mainRepository: MainRepository
    ) {
    suspend fun insertMainRemoteToDB() {
        return mainRepository.insertMainRemoteToDB()
    }
}