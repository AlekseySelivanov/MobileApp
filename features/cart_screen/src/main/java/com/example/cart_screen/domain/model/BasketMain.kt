package com.example.cart_screen.domain.model

data class BasketMain(
    val _id: String = "",
    val basket: List<BasketProduct>? =  null,
    val delivery: String = "",
    val total: Int =  0
)