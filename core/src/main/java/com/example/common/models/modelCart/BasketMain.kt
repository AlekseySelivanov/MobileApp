package com.example.common.models.modelCart

data class BasketMain(
    val _id: String = "",
    val basket: List<BasketProduct>? =  null,
    val delivery: String = "",
    val total: Int =  0
)