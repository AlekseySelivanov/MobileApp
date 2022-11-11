package com.example.common.dataSource.remote

import com.example.common.models.modelRemote.MainRemote
import com.example.common.network.MainApiService
import javax.inject.Inject

class MainRemoteDataSourceImpl @Inject constructor(
    private val mainApiService: MainApiService
    ) : MainRemoteDataSource {

    override suspend fun getMainRemote(): MainRemote {
        return mainApiService.getMain()
    }
}