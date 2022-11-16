package com.example.product_details_screen.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.common.constants.Constants.PRODUCT_DETAILS_DATABASE_VERSION
import com.example.product_details_screen.data.dataBase.model.ProductDetailsItemDB

@Database(entities = [ProductDetailsItemDB::class], version = PRODUCT_DETAILS_DATABASE_VERSION, exportSchema = false)
@TypeConverters(PDItemTypeConverters::class)
abstract class ProductDetailsDatabase : RoomDatabase() {

    abstract fun productDetailsDao(): ProductDetailsDao

}