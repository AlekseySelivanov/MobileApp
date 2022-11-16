package com.example.home_screen.home_screen.domain.model

data class HomeStore(
    val id: Int,
    val title: String,
    val subtitle: String,
    val picture: String,
    val isBuy: Boolean,
)