package com.example.home_screen.home_screen.data.repository

import com.example.home_screen.home_screen.domain.model.BestSeller
import com.example.home_screen.home_screen.domain.repository.MainRepository
import com.example.home_screen.home_screen.data.datasource.local.MainLocalDataSource
import com.example.home_screen.home_screen.data.datasource.remote.MainRemoteDataSource
import com.example.home_screen.home_screen.data.mapper.MainMapper
import com.example.home_screen.home_screen.domain.model.HomeStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainRemoteDataSource: MainRemoteDataSource,
    private val mainLocalDataSource: MainLocalDataSource,
    private val mainMapper: MainMapper
) : MainRepository {

    override suspend fun getBestSellerPhonesList(): List<BestSeller> {
        return mainMapper.mapListBestsellerDBToListBestseller(
            mainLocalDataSource.getBestSellerDBPhonesList()
        )
    }

    override suspend fun getHomeStorePhonesList(): List<HomeStore> {
        return mainMapper.mapListHomeStoreDBToListHomeStore(
            mainLocalDataSource.getHomeStoreDBPhonesList()
        )
    }

    override suspend fun addBookmark(bestSeller: BestSeller) {
        mainLocalDataSource.addBookmark(mainMapper.mapBestsellerToBookmarkDB(bestSeller))
    }

    override suspend fun deleteBookmark(bestSeller: BestSeller) {
        mainLocalDataSource.deleteBookmark(mainMapper.mapBestsellerToBookmarkDB(bestSeller))
    }

    override suspend fun insertMainRemoteToDB() {
        withContext(Dispatchers.IO) {
            mainLocalDataSource.insertMainDBToDB(
                mainMapper.mapMainRemoteToMainDB(
                    mainRemoteDataSource.getMainRemote()
                )
            )
        }
    }
}