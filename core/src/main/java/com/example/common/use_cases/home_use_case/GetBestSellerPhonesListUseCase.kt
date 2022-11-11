package com.example.common.use_cases.home_use_case

import com.example.common.models.BestSeller
import com.example.common.repositories.homeRepositories.MainRepository
import javax.inject.Inject

class GetBestSellerPhonesListUseCase@Inject constructor(private val mainRepository: MainRepository) {

    suspend fun getBestSellerPhonesList(): List<BestSeller> {
        return mainRepository.getBestSellerPhonesList()
    }
}
