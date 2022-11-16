package com.example.product_details_screen.ui

sealed class DetailsApiStatus {
    object LOADING : DetailsApiStatus()
    class ERROR(val error: String) : DetailsApiStatus()
    object DONE : DetailsApiStatus()
}