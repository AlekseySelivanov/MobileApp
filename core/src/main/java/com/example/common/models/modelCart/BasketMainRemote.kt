package com.example.common.models.modelCart

data class BasketMainRemote(
    val id: String,
    val basket: List<BasketProductRemote>,
    val delivery: String,
    val total: Int
)