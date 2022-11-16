package com.example.home_screen.home_screen.data.datasource.remote

import com.example.home_screen.home_screen.data.network.modelRemote.MainRemote

interface MainRemoteDataSource {

    suspend fun getMainRemote(): MainRemote
}