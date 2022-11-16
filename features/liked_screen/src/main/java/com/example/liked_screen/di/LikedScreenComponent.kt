package com.example.liked_screen.di

import android.content.Context
import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import com.example.liked_screen.data.dataSource.local.BookmarkLocalDataSource
import com.example.liked_screen.data.mapper.BookmarkMapper
import com.example.liked_screen.data.repository.BookmarkRepositoryImpl
import com.example.liked_screen.di.modules.DatabaseModule
import com.example.liked_screen.di.modules.LikedModule
import com.example.liked_screen.di.modules.RepositoryModule
import com.example.liked_screen.domain.repository.BookmarkRepository
import com.example.liked_screen.domain.usecase.DeleteAllBookmarksUseCase
import com.example.liked_screen.domain.usecase.DeleteBookmarkUseCase
import com.example.liked_screen.domain.usecase.GetBookmarksListUseCase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [LikedModule::class, DatabaseModule::class, RepositoryModule::class]
)
interface LikedScreenComponent {
    fun appContext(): Context

    fun bookmarkRepository(): BookmarkRepository
    fun bookmarkRepositoryImpl(): BookmarkRepositoryImpl
    fun bookmarkLocalDataSource(): BookmarkLocalDataSource
    fun deleteAllBookmarksUseCase(): DeleteAllBookmarksUseCase
    fun deleteBookmarkUseCase(): DeleteBookmarkUseCase
    fun getBookmarksListUseCase(): GetBookmarksListUseCase
    fun bookmarkMapper(): BookmarkMapper
    fun bookmarkDao(): BookmarkDao

}