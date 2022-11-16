package com.example.liked_screen.di.modules

import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import com.example.liked_screen.data.dataSource.local.BookmarkLocalDataSource
import com.example.liked_screen.data.dataSource.local.BookmarkLocalDataSourceImpl
import com.example.liked_screen.data.mapper.BookmarkMapper
import com.example.liked_screen.data.repository.BookmarkRepositoryImpl
import com.example.liked_screen.domain.repository.BookmarkRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideBookmarkRepository(
        bookmarkLocalDataSource: BookmarkLocalDataSource,
        bookmarkMapper: BookmarkMapper
    ): BookmarkRepository = BookmarkRepositoryImpl(
        bookmarkLocalDataSource,
        bookmarkMapper
    )

    @Provides
    @Singleton
    fun provideBookmarkLocalDataSource(
        bookmarkDao: BookmarkDao
    ): BookmarkLocalDataSource =
        BookmarkLocalDataSourceImpl(bookmarkDao)

}