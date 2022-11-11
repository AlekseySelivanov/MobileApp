package com.example.common.use_cases.home_use_case

import com.example.common.models.home_model.HomeStore
import com.example.common.repositories.homeRepositories.MainRepository
import javax.inject.Inject

class GetHomeStorePhonesListUseCase @Inject constructor(
    private val mainRepository: MainRepository
    ) {

    suspend fun getHomeStorePhonesList(): List<HomeStore> {
        return mainRepository.getHomeStorePhonesList()
    }
}