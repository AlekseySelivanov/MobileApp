package com.example.cart_screen.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.common.constants.Constants.MY_CART_DATABASE_TABLE_NAME

@Entity(tableName = MY_CART_DATABASE_TABLE_NAME)
data class BasketMainDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val basket: List<BasketProductDB>,
    val delivery: String,
    val total: Int
)