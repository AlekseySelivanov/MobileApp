package com.example.common.repositories.homeRepositories

import com.example.common.dataSource.local.MainLocalDataSource
import com.example.common.dataSource.remote.MainRemoteDataSource
import com.example.common.mapper.MainMapper
import com.example.common.models.BestSeller
import com.example.common.models.home_model.HomeStore
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