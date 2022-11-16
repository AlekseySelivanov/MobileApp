package com.example.home_screen.home_screen.di

import android.content.Context
import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import com.example.home_screen.home_screen.data.mapper.MainMapper
import com.example.home_screen.home_screen.data.repository.MainRepositoryImpl
import com.example.home_screen.home_screen.di.modules.DatabaseModule
import com.example.home_screen.home_screen.di.modules.HomeModule
import com.example.home_screen.home_screen.di.modules.NetworkModule
import com.example.home_screen.home_screen.di.modules.RepositoryModule
import com.example.home_screen.home_screen.domain.repository.MainRepository
import com.example.home_screen.home_screen.domain.useCases.GetBestSellerPhonesListUseCase
import com.example.home_screen.home_screen.domain.useCases.GetHomeStorePhonesListUseCase
import com.example.home_screen.home_screen.domain.useCases.InsertMainRemoteToDBUseCase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [HomeModule::class, DatabaseModule::class, NetworkModule::class, RepositoryModule::class]
)
interface HomeScreenComponent {
    fun appContext(): Context

    fun mainRepository(): MainRepository
    fun mainRepositoryImpl(): MainRepositoryImpl
    fun getGetHomeStorePhonesListUseCase(): GetHomeStorePhonesListUseCase
    fun getBestSellerPhonesListUseCase(): GetBestSellerPhonesListUseCase
    fun getInsertMainRemoteToDBUseCase(): InsertMainRemoteToDBUseCase
    fun myMainMapper(): MainMapper
    fun bookmarkDao(): BookmarkDao

}