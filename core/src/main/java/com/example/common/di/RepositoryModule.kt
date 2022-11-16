package com.example.common.di

import com.example.common.dataSource.local.database.AppLocalDataSource
import com.example.common.dataSource.local.database.AppLocalDataSourceImpl
import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import com.example.common.mapper.*
import com.example.common.repositories.homeRepositories.AppRepository
import com.example.common.repositories.homeRepositories.AppRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideAppRepository(
        appLocalDataSource: AppLocalDataSource,
        appMapper: AppMapper
    ): AppRepository = AppRepositoryImpl(appLocalDataSource,appMapper)

    @Provides
    fun productAppLocalDataSource(
        bookmarkDao: BookmarkDao
    ): AppLocalDataSource = AppLocalDataSourceImpl(bookmarkDao)

}