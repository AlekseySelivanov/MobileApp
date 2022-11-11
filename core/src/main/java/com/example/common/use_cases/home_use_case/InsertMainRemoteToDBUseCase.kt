package com.example.common.use_cases.home_use_case

import com.example.common.repositories.homeRepositories.MainRepository
import javax.inject.Inject

class InsertMainRemoteToDBUseCase @Inject constructor (
    private val mainRepository: MainRepository
    ) {
    suspend fun insertMainRemoteToDB() {
        return mainRepository.insertMainRemoteToDB()
    }
}