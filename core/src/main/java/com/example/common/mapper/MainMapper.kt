package com.example.common.mapper

import com.example.common.models.BestSeller
import com.example.common.models.home_model.HomeStore
import com.example.common.models.modelDB.BestSellerDB
import com.example.common.models.modelDB.HomeStoreDB
import com.example.common.dataSource.local.database.MainDB
import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB
import com.example.common.models.modelRemote.BestSellerRemote
import com.example.common.models.modelRemote.HomeStoreRemote
import com.example.common.models.modelRemote.MainRemote
import javax.inject.Inject

class MainMapper @Inject constructor() {

    fun mapListBestsellerDBToListBestseller(
        listBestsellerDB: List<BestSellerDB>
    ): List<BestSeller> =
        listBestsellerDB.map {
            BestSeller(
                id = it.id,
                isFavorites = it.isFavorites,
                title = it.title,
                priceWithoutDiscount = it.priceWithoutDiscount,
                discountPrice = it.discountPrice,
                picture = it.picture
            )
        }

    fun mapListHomeStoreDBToListHomeStore(listHomeStoreDB: List<HomeStoreDB>): List<HomeStore> =
        listHomeStoreDB.map {
            HomeStore(
                id = it.id,
                title = it.title,
                subtitle = it.subtitle,
                picture = it.picture,
                isBuy = it.isBuy
            )
        }

    fun mapBestsellerToBookmarkDB(bestSeller: BestSeller): PhoneBookmarkDB =
        PhoneBookmarkDB(
            id = bestSeller.id,
            title = bestSeller.title,
            picture = bestSeller.picture,
            priceWithoutDiscount = bestSeller.priceWithoutDiscount,
            discountPrice = bestSeller.discountPrice
        )

    private fun mapListHomeStoreRemoteToListHomeStoreDB(
        listHomeStoreRemote: List<HomeStoreRemote>
    ): List<HomeStoreDB> = listHomeStoreRemote.map {
        HomeStoreDB(
            id = it.id,
            title = it.title,
            subtitle = it.subtitle,
            picture = it.picture,
            isBuy = it.isBuy
        )
    }

    private fun mapListBestsellerRemoteToListBestsellerDB(
        listBestsellerRemote: List<BestSellerRemote>
    ): List<BestSellerDB> = listBestsellerRemote.map {
        BestSellerDB(
            id = it.id,
            isFavorites = it.isFavorites,
            title = it.title,
            priceWithoutDiscount = it.priceWithoutDiscount,
            discountPrice = it.discountPrice,
            picture = it.picture
        )
    }

    fun mapMainRemoteToMainDB(mainRemote: MainRemote): MainDB {
        return MainDB(
            homeStore = mapListHomeStoreRemoteToListHomeStoreDB(mainRemote.homeStore),
            bestSeller = mapListBestsellerRemoteToListBestsellerDB(mainRemote.bestSeller)
        )
    }
}