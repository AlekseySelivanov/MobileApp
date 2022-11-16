package com.example.cart_screen.data.network.model

data class BasketMainRemote(
    val id: String,
    val basket: List<BasketProductRemote>,
    val delivery: String,
    val total: Int
)