package com.example.common.dataSource.remote

import com.example.common.models.modelRemote.MainRemote

interface MainRemoteDataSource {

    suspend fun getMainRemote(): MainRemote
}