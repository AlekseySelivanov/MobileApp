package com.example.navigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class Destination : Parcelable {
    @Parcelize
    object ClearBackStack: Destination()

    @Parcelize
    object Home: Destination()

    @Parcelize
    object ProductDetails: Destination()

    @Parcelize
    object Cart: Destination()

    @Parcelize
    object Liked: Destination()

    @Parcelize
    object Maps: Destination()

    @Parcelize
    object Back: Destination()
}
