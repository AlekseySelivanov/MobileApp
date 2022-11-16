package com.example.cart_screen.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.common.constants.Constants.MY_CART_DATABASE_VERSION
import com.example.cart_screen.data.database.model.BasketMainDB

@Database(
    entities = [BasketMainDB::class],
    version = MY_CART_DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(MyCartTypeConverters::class)
abstract class MyCartDatabase : RoomDatabase() {

    abstract fun myCartDao(): MyCartDao
}