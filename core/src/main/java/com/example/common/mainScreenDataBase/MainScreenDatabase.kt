package com.example.common.mainScreenDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.common.constants.Constants.MAIN_SCREEN_DATABASE_VERSION
import com.example.common.dataSource.local.database.MainDB

@Database(entities = [MainDB::class], version = MAIN_SCREEN_DATABASE_VERSION, exportSchema = false)
@TypeConverters(MainScreenTypeConverters::class)
abstract class MainScreenDatabase : RoomDatabase() {

    abstract fun mainScreenDao(): MainScreenDao

}