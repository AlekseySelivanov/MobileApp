package com.example.cart_screen.domain.repository

import com.example.cart_screen.domain.model.BasketMain

interface MyCartRepository {

    suspend fun getMyCart(): BasketMain

    suspend fun insertMyCartToDB()
}

