package com.example.home_screen.home_screen.domain.model

data class BestSeller(
    val id: Int ,
    val isFavorites: Boolean,
    val title: String,
    val priceWithoutDiscount: Int,
    val discountPrice: Int,
    val picture: String,
    var pressed: Boolean = false
)

