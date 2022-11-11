package com.example.common.use_cases.cart_usecase

import com.example.common.repositories.cart_repositories.MyCartRepository
import javax.inject.Inject

class InsertMyCartToDBUseCase @Inject constructor(private val myCartRepository: MyCartRepository) {

    suspend fun insertMyCartToDB() {
        return myCartRepository.insertMyCartToDB()
    }
}