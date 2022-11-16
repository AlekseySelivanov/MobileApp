package com.example.home_screen.home_screen.data.mapper

import com.example.home_screen.home_screen.domain.model.BestSeller
import com.example.home_screen.home_screen.domain.model.HomeStore
import com.example.common.dataSource.local.database.liked_database.PhoneBookmarkDB
import com.example.home_screen.home_screen.data.network.modelRemote.BestSellerRemote
import com.example.home_screen.home_screen.data.network.modelRemote.HomeStoreRemote
import com.example.home_screen.home_screen.data.network.modelRemote.MainRemote
import com.example.home_screen.home_screen.data.database.ModelDB.BestSellerDB
import com.example.home_screen.home_screen.data.database.ModelDB.HomeStoreDB
import com.example.home_screen.home_screen.data.database.ModelDB.MainDB
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