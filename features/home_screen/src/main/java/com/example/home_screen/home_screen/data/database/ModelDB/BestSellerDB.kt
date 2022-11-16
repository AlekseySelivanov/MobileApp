package com.example.home_screen.home_screen.data.database.ModelDB

data class BestSellerDB(
    val id: Int,
    val isFavorites: Boolean,
    val title: String,
    val priceWithoutDiscount: Int,
    val discountPrice: Int,
    val picture: String
)

