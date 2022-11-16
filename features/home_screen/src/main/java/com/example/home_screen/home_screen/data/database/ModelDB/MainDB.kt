package com.example.home_screen.home_screen.data.database.ModelDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main_screen_cache")
data class MainDB(
    val homeStore: List<HomeStoreDB>,
    val bestSeller: List<BestSellerDB>
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}