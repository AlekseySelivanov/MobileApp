package com.example.cart_screen.domain.useCases

import com.example.cart_screen.domain.model.BasketMain
import com.example.cart_screen.domain.repository.MyCartRepository
import javax.inject.Inject

class GetMyCartUseCase @Inject constructor(private val myCartRepository: MyCartRepository) {

    suspend fun getMyCart(): BasketMain {
        return myCartRepository.getMyCart()
    }
}