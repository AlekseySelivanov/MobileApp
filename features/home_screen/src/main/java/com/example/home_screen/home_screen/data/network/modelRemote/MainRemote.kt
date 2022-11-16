package com.example.home_screen.home_screen.data.network.modelRemote

import com.example.common.constants.Constants.MAIN_REMOTE_BESTSELLER
import com.example.common.constants.Constants.MAIN_REMOTE_HOME_STORE
import com.squareup.moshi.Json

data class MainRemote(
    @Json(name = MAIN_REMOTE_HOME_STORE) val homeStore: List<HomeStoreRemote>,
    @Json(name = MAIN_REMOTE_BESTSELLER) val bestSeller: List<BestSellerRemote>
)