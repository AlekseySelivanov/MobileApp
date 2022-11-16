package com.example.cart_screen.domain.useCases

import com.example.cart_screen.domain.repository.MyCartRepository
import javax.inject.Inject

class InsertMyCartToDBUseCase @Inject constructor(private val myCartRepository: MyCartRepository) {

    suspend fun insertMyCartToDB() {
        return myCartRepository.insertMyCartToDB()
    }
}