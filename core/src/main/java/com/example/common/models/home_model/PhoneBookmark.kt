package com.example.common.models.home_model

data class PhoneBookmark(
    val id: Int,
    val title: String,
    val priceWithoutDiscount: Int,
    val discountPrice: Int,
    val picture: String
)