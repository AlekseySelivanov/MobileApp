package com.example.common.di

import android.content.Context
import com.example.common.dataSource.local.MainLocalDataSource
import com.example.common.dataSource.local.ProductDetailsLocalDataSource
import com.example.common.dataSource.local.database.ProductDetailsDao
import com.example.common.dataSource.local.liked_screen.BookmarkLocalDataSource
import com.example.common.dataSource.remote.MainRemoteDataSource
import com.example.common.dataSource.remote.ProductDetailsRemoteDataSource
import com.example.common.dataSource.remote.network.ProductDetailsApiService
import com.example.common.di.viewmodel.ViewModelBuilderModule
import com.example.common.mapper.BookmarkMapper
import com.example.common.mapper.MainMapper
import com.example.common.mapper.ProductDetailsMapper
import com.example.common.network.MainApiService
import com.example.common.repositories.homeRepositories.AppRepository
import com.example.common.repositories.homeRepositories.MainRepository
import com.example.common.repositories.homeRepositories.MainRepositoryImpl
import com.example.common.repositories.liked_repositories.BookmarkRepository
import com.example.common.use_cases.cart_usecase.GetMyCartUseCase
import com.example.common.use_cases.cart_usecase.InsertMyCartToDBUseCase
import com.example.common.use_cases.home_use_case.GetBestSellerPhonesListUseCase
import com.example.common.use_cases.home_use_case.GetBookmarksListUseCase
import com.example.common.use_cases.home_use_case.GetHomeStorePhonesListUseCase
import com.example.common.use_cases.home_use_case.InsertMainRemoteToDBUseCase
import com.example.common.use_cases.liked_use_case.DeleteAllBookmarksUseCase
import com.example.common.use_cases.liked_use_case.DeleteBookmarkUseCase
import com.example.common.use_cases.product_details.GetProductDetailsUseCase
import com.example.common.use_cases.product_details.InsertProductDetailsToDBUseCase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, DatabaseModule::class, ViewModelBuilderModule::class, NetworkModule::class, RepositoryModule::class])
interface CoreComponent {
    fun appContext(): Context

    fun provideMainRepository(): MainRepository
    fun mainRepository(): MainRepositoryImpl
    fun mainMapper(): MainMapper
    fun mainLocalDataSource(): MainLocalDataSource
    fun mainRemoteDataSource(): MainRemoteDataSource
    fun userService(): MainApiService
    fun getGetHomeStorePhonesListUseCase(): GetHomeStorePhonesListUseCase
    fun getBestSellerPhonesListUseCase(): GetBestSellerPhonesListUseCase
    fun getInsertMainRemoteToDBUseCase(): InsertMainRemoteToDBUseCase
    fun productDetailsRemoteDataSource(): ProductDetailsRemoteDataSource
    fun productDetailsMapper(): ProductDetailsMapper
    fun productDetailsLocalDataSource(): ProductDetailsLocalDataSource
    fun productDetailsApiService(): ProductDetailsApiService
    fun productDetailsDao(): ProductDetailsDao
    fun getProductDetailsUseCase(): GetProductDetailsUseCase
    fun insertProductDetailsToDBUseCase(): InsertProductDetailsToDBUseCase
    fun getMyCartUseCase(): GetMyCartUseCase
    fun insertMyCartToDBUseCase(): InsertMyCartToDBUseCase
    fun appRepository(): AppRepository
    fun getBookmarksListUseCase(): GetBookmarksListUseCase
    fun deleteAllBookmarksUseCase(): DeleteAllBookmarksUseCase
    fun deleteBookmarkUseCase(): DeleteBookmarkUseCase
    fun bookmarkRepository(): BookmarkRepository
    fun bookmarkLocalDataSource(): BookmarkLocalDataSource
    fun bookmarkMapper(): BookmarkMapper

}