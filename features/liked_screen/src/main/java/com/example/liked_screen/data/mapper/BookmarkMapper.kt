package com.example.liked_screen.data.mapper

import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB
import com.example.liked_screen.domain.model.PhoneBookmark
import javax.inject.Inject

class BookmarkMapper @Inject constructor(){

    fun mapListBookmarkDBToListBookmark(listPhoneBookmarkDB: List<PhoneBookmarkDB>): List<PhoneBookmark> =
        listPhoneBookmarkDB.map {
            PhoneBookmark(
                id = it.id,
                title = it.title,
                priceWithoutDiscount = it.priceWithoutDiscount,
                discountPrice = it.discountPrice,
                picture = it.picture
            )
        }

    fun mapBookmarkToPhoneBookmarkDB(phoneBookmark: PhoneBookmark): PhoneBookmarkDB =
        PhoneBookmarkDB(
            id = phoneBookmark.id,
            title = phoneBookmark.title,
            picture = phoneBookmark.picture,
            priceWithoutDiscount = phoneBookmark.priceWithoutDiscount,
            discountPrice = phoneBookmark.discountPrice
        )
}