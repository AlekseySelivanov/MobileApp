package com.example.common.dataSource.local.database.liked_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phone_table")
data class PhoneBookmarkDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val priceWithoutDiscount: Int,
    val discountPrice: Int,
    val picture: String
)


