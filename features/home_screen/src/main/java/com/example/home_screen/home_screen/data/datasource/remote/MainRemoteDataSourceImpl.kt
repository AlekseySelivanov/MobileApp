package com.example.home_screen.home_screen.data.datasource.remote

import com.example.home_screen.home_screen.data.network.modelRemote.MainRemote
import com.example.home_screen.home_screen.data.network.MainApiService
import javax.inject.Inject

class MainRemoteDataSourceImpl @Inject constructor(
    private val mainApiService: MainApiService
    ) : MainRemoteDataSource {

    override suspend fun getMainRemote(): MainRemote {
        return mainApiService.getMain()
    }
}