package com.example.common.mapper

import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB
import com.example.common.models.home_model.PhoneBookmark

import javax.inject.Inject

class AppMapper @Inject constructor() {

    fun mapListPhoneBookmarkDBToListPhoneBookmark(
        listPhoneBookmarkDB: List<PhoneBookmarkDB>
    ): List<PhoneBookmark> =
        listPhoneBookmarkDB.map {
            PhoneBookmark(
                id = it.id,
                title = it.title,
                picture = it.picture,
                priceWithoutDiscount = it.priceWithoutDiscount,
                discountPrice = it.discountPrice
            )
        }
}