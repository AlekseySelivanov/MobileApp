package com.example.common.dataSource.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.common.models.modelDB.BestSellerDB
import com.example.common.models.modelDB.HomeStoreDB

@Entity(tableName = "main_screen_cache")
data class MainDB(
    val homeStore: List<HomeStoreDB>,
    val bestSeller: List<BestSellerDB>
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}