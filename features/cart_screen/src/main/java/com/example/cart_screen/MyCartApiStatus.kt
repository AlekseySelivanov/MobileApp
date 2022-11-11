package com.example.cart_screen

sealed class MyCartApiStatus {
    object LOADING : MyCartApiStatus()
    class ERROR(val error: String) : MyCartApiStatus()
    object DONE : MyCartApiStatus()
}