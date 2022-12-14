package com.example.product_details_screen.data.network.model

import com.example.common.constants.Constants.PRODUCT_DETAILS_ITEM_REMOTE_ATTRIBUTE_CPU
import com.squareup.moshi.Json

data class ProductDetailsItemRemote(
    @Json(name = PRODUCT_DETAILS_ITEM_REMOTE_ATTRIBUTE_CPU) val cpu: String,
    val id: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String
)