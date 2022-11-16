package com.example.liked_screen.di.modules

import android.content.Context
import androidx.room.Room
import com.example.common.constants.Constants
import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import com.example.common.dataSource.local.database.liked_database.BookmarkDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideBookmarkDatabase( context: Context): BookmarkDatabase = Room
        .databaseBuilder(
            context,
            BookmarkDatabase::class.java,
            Constants.BOOKMARK_DATABASE_NAME

        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideBookmarkDao(appDatabase: BookmarkDatabase): BookmarkDao = appDatabase.bookmarkDao()
}