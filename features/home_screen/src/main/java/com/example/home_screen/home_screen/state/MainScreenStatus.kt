package com.example.home_screen.home_screen.state

sealed class MainScreenStatus {
    object LOADING : MainScreenStatus()
    class ERROR(val error: String) : MainScreenStatus()
    object DONE : MainScreenStatus()
}