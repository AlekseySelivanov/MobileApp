package com.example.home_screen.home_screen.domain.useCases

import com.example.home_screen.home_screen.domain.model.HomeStore
import com.example.home_screen.home_screen.domain.repository.MainRepository
import javax.inject.Inject

class GetHomeStorePhonesListUseCase @Inject constructor(
    private val mainRepository: MainRepository
    ) {

    suspend fun getHomeStorePhonesList(): List<HomeStore> {
        return mainRepository.getHomeStorePhonesList()
    }
}