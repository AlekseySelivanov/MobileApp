package com.example.home_screen.home_screen.domain.useCases

import com.example.home_screen.home_screen.domain.model.BestSeller
import com.example.home_screen.home_screen.domain.repository.MainRepository
import javax.inject.Inject

class GetBestSellerPhonesListUseCase@Inject constructor(private val mainRepository: MainRepository) {

    suspend fun getBestSellerPhonesList(): List<BestSeller> {
        return mainRepository.getBestSellerPhonesList()
    }
}
