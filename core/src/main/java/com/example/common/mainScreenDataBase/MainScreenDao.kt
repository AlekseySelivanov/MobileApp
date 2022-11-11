package com.example.common.mainScreenDataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.common.dataSource.local.database.MainDB

@Dao
interface MainScreenDao {

    @Query("SELECT * FROM main_screen_cache")
    suspend fun getListMainDB(): List<MainDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMainDB(mainDB: MainDB)
}