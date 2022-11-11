package com.example.common.dataSource.local.database.liked_database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM phone_table ORDER BY id")
    fun getBookmarks(): LiveData<List<PhoneBookmarkDB>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    @Delete
    suspend fun deleteBookmark(phoneBookmarkDB: PhoneBookmarkDB)

    @Query("DELETE FROM phone_table")
    suspend fun deleteAllBookmarks()
}