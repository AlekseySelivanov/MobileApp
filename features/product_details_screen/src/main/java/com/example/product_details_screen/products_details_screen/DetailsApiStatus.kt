package com.example.product_details_screen.products_details_screen

sealed class DetailsApiStatus {
    object LOADING : DetailsApiStatus()
    class ERROR(val error: String) : DetailsApiStatus()
    object DONE : DetailsApiStatus()
}