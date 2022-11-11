package com.example.common.models

data class ProductDetailsItem(
    val cpu: String? = null,
    val id: String? = null,
    val camera: String? = null,
    val capacity: List<String>? = null,
    val color: List<String>? =  null,
    val images: List<String> = listOf(),
    val isFavorites: Boolean = false,
    val price: Int =  0,
    val rating: Double =  0.0,
    val sd: String = "",
    val ssd: String = "",
    val title: String = ""
)