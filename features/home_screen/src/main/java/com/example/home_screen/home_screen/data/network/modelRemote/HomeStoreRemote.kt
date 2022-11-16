package com.example.home_screen.home_screen.data.network.modelRemote

import com.example.common.constants.Constants.HOME_STORE_REMOTE_IS_BUY_NAME
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeStoreRemote(
    val id: Int,
    val title: String,
    val subtitle: String,
    val picture: String,
    @Json(name = HOME_STORE_REMOTE_IS_BUY_NAME) val isBuy: Boolean,
)