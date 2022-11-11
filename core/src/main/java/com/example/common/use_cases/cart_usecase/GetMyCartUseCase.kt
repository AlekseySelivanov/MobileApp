package com.example.common.use_cases.cart_usecase

import com.example.common.models.modelCart.BasketMain
import com.example.common.repositories.cart_repositories.MyCartRepository
import javax.inject.Inject

class GetMyCartUseCase @Inject constructor(private val myCartRepository: MyCartRepository) {

    suspend fun getMyCart(): BasketMain {
        return myCartRepository.getMyCart()
    }
}


