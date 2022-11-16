package com.example.home_screen.home_screen.di.modules

import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import com.example.home_screen.home_screen.data.database.MainScreenDao
import com.example.home_screen.home_screen.data.datasource.local.MainLocalDataSource
import com.example.home_screen.home_screen.data.datasource.local.MainLocalDataSourceImpl
import com.example.home_screen.home_screen.data.datasource.remote.MainRemoteDataSource
import com.example.home_screen.home_screen.data.datasource.remote.MainRemoteDataSourceImpl
import com.example.home_screen.home_screen.data.mapper.MainMapper
import com.example.home_screen.home_screen.data.network.MainApiService
import com.example.home_screen.home_screen.data.repository.MainRepositoryImpl
import com.example.home_screen.home_screen.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        mainRemoteDataSource: MainRemoteDataSource,
        mainLocalDataSource: MainLocalDataSource,
        mainMapper: MainMapper
    ): MainRepository = MainRepositoryImpl(
        mainRemoteDataSource,
        mainLocalDataSource,
        mainMapper
    )

    @Provides
    @Singleton
    fun provideMainLocalDataSource(
        bookmarkDao: BookmarkDao,
        mainScreenDao: MainScreenDao
    ): MainLocalDataSource =
        MainLocalDataSourceImpl(
            bookmarkDao,
            mainScreenDao
        )

    @Provides
    @Singleton
    fun provideMainRemoteDataSource(
        mainApiService: MainApiService
    ): MainRemoteDataSource =
        MainRemoteDataSourceImpl(
            mainApiService
        )
}