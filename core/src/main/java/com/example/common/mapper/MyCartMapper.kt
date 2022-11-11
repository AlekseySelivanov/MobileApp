package com.example.common.mapper

import com.example.common.dataSource.local.database.BasketMainDB
import com.example.common.models.modelCart.*
import javax.inject.Inject

class MyCartMapper @Inject constructor() {

    fun mapBasketMainRemoteToBasketMainDB(basketMainRemote: BasketMainRemote) =
        BasketMainDB(
            id = basketMainRemote.id.toInt(),
            basket = mapBasketProductRemoteToBasketProductDB(basketMainRemote.basket),
            delivery = basketMainRemote.delivery,
            total = basketMainRemote.total
        )

    private fun mapBasketProductRemoteToBasketProductDB(
        listBasketProductRemote: List<BasketProductRemote>
    ): List<BasketProductDB> = listBasketProductRemote.map {
        BasketProductDB(
            id = it.id,
            images = it.images,
            price = it.price,
            title = it.title
        )
    }

    private fun mapBasketProductDBToBasketProduct(
        listBasketProductDB: List<BasketProductDB>
    ): List<BasketProduct> = listBasketProductDB.map {
        BasketProduct(
            id = it.id,
            images = it.images,
            price = it.price,
            title = it.title
        )
    }

    fun mapListBasketMainDBToListBasketMain(
        listBasketMainDB: List<BasketMainDB>
    ): List<BasketMain> =
        listBasketMainDB.map {
            BasketMain(
                _id = it.id.toString(),
                basket = mapBasketProductDBToBasketProduct(it.basket),
                delivery = it.delivery,
                total = it.total
            )
        }
}