package com.example.common.dataSource.local.database.liked_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.common.constants.Constants.BOOKMARK_DATABASE_VERSION

@Database(entities = [PhoneBookmarkDB::class], version = BOOKMARK_DATABASE_VERSION, exportSchema = false)
abstract class BookmarkDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao

}