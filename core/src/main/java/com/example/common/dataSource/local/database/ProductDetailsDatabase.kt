package com.example.common.dataSource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.common.constants.Constants.PRODUCT_DETAILS_DATABASE_VERSION

@Database(entities = [ProductDetailsItemDB::class], version = PRODUCT_DETAILS_DATABASE_VERSION, exportSchema = false)
@TypeConverters(PDItemTypeConverters::class)
abstract class ProductDetailsDatabase : RoomDatabase() {

    abstract fun productDetailsDao(): ProductDetailsDao

}