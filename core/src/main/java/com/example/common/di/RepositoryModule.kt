package com.example.common.di

import com.example.common.dataSource.local.*
import com.example.common.dataSource.local.database.AppLocalDataSource
import com.example.common.dataSource.local.database.AppLocalDataSourceImpl
import com.example.common.mainScreenDataBase.MainScreenDao
import com.example.common.repositories.homeRepositories.MainRepositoryImpl
import com.example.common.dataSource.local.database.ProductDetailsDao
import com.example.common.dataSource.local.database.cart_database.MyCartDao
import com.example.common.dataSource.local.database.liked_database.BookmarkDao
import com.example.common.dataSource.local.liked_screen.BookmarkLocalDataSource
import com.example.common.dataSource.local.liked_screen.BookmarkLocalDataSourceImpl
import com.example.common.dataSource.remote.*
import com.example.common.dataSource.remote.network.MyCartApiService
import com.example.common.dataSource.remote.network.ProductDetailsApiService
import com.example.common.mapper.*
import com.example.common.network.MainApiService
import com.example.common.repositories.cart_repositories.MyCartRepository
import com.example.common.repositories.cart_repositories.MyCartRepositoryImpl
import com.example.common.repositories.homeRepositories.AppRepository
import com.example.common.repositories.homeRepositories.AppRepositoryImpl
import com.example.common.repositories.homeRepositories.MainRepository
import com.example.common.repositories.liked_repositories.BookmarkRepository
import com.example.common.repositories.liked_repositories.BookmarkRepositoryImpl
import com.example.common.repositories.product_details.ProductDetailsRepository
import com.example.common.repositories.product_details.ProductDetailsRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideMainRepository(
        mainRemoteDataSource: MainRemoteDataSource,
        mainLocalDataSource: MainLocalDataSource,
        mainMapper: MainMapper
    ): MainRepository = MainRepositoryImpl(mainRemoteDataSource,mainLocalDataSource, mainMapper)

    @Provides
    fun provideMainLocalDataSource(
        bookmarkDao: BookmarkDao,
        mainScreenDao: MainScreenDao
    ): MainLocalDataSource = MainLocalDataSourceImpl(bookmarkDao,mainScreenDao)

    @Provides
    fun provideMainRemoteDataSource(
        mainApiService: MainApiService
    ): MainRemoteDataSource = MainRemoteDataSourceImpl(mainApiService)

    @Provides
    fun provideProductDetailsRepository(
        productDetailsRemoteDataSource: ProductDetailsRemoteDataSource,
        productDetailsMapper: ProductDetailsMapper,
        productDetailsLocalDataSource: ProductDetailsLocalDataSource
    ): ProductDetailsRepository = ProductDetailsRepositoryImpl(productDetailsRemoteDataSource,productDetailsMapper,productDetailsLocalDataSource)

    @Provides
    fun productDetailsRemoteDataSource(
        productDetailsApiService: ProductDetailsApiService
    ): ProductDetailsRemoteDataSource = ProductDetailsRemoteDataSourceImpl(productDetailsApiService)

    @Provides
    fun productDetailsLocalDataSource(
        productDetailsDao: ProductDetailsDao
    ): ProductDetailsLocalDataSource = ProductDetailsLocalDataSourceImpl(productDetailsDao)

    @Provides
    fun provideMyCartRepository(
        myCartRemoteDataSource: MyCartRemoteDataSource,
        myCartMapper: MyCartMapper,
        myCartLocalDataSource: MyCartLocalDataSource
    ): MyCartRepository = MyCartRepositoryImpl(myCartRemoteDataSource,myCartMapper,myCartLocalDataSource)

    @Provides
    fun productMyCartRemoteDataSource(
        myCartApiService: MyCartApiService
    ): MyCartRemoteDataSource = MyCartRemoteDataSourceImpl(myCartApiService)

    @Provides
    fun productMyCartLocalDataSource(
        myCartDao: MyCartDao
    ): MyCartLocalDataSource = MyCartLocalDataSourceImpl(myCartDao)

    @Provides
    fun provideAppRepository(
        appLocalDataSource: AppLocalDataSource,
        appMapper: AppMapper
    ): AppRepository = AppRepositoryImpl(appLocalDataSource,appMapper)

    @Provides
    fun productAppLocalDataSource(
        bookmarkDao: BookmarkDao
    ): AppLocalDataSource = AppLocalDataSourceImpl(bookmarkDao)

    @Provides
    fun provideBookmarkRepository(
       bookmarkLocalDataSource: BookmarkLocalDataSource,
       bookmarkMapper: BookmarkMapper
    ): BookmarkRepository = BookmarkRepositoryImpl(bookmarkLocalDataSource,bookmarkMapper)


    @Provides
    fun provideBookmarkLocalDataSource(
        bookmarkDao: BookmarkDao
    ): BookmarkLocalDataSource = BookmarkLocalDataSourceImpl(bookmarkDao)

}