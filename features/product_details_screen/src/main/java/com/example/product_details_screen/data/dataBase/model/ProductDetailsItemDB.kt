package com.example.product_details_screen.data.dataBase.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.common.constants.Constants.PRODUCT_DETAILS_DATABASE_TABLE_NAME

@Entity(tableName = PRODUCT_DETAILS_DATABASE_TABLE_NAME)
data class ProductDetailsItemDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val cpu: String,
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