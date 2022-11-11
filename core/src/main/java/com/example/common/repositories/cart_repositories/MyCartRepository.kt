package com.example.common.repositories.cart_repositories

import com.example.common.models.modelCart.BasketMain

interface MyCartRepository {

    suspend fun getMyCart(): BasketMain

    suspend fun insertMyCartToDB()
}

