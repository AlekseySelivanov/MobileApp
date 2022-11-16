package com.example.cart_screen.data.mapper

import com.example.cart_screen.data.network.model.BasketMainRemote
import com.example.cart_screen.data.network.model.BasketProductRemote
import com.example.cart_screen.domain.model.BasketMain
import com.example.cart_screen.domain.model.BasketProduct
import javax.inject.Inject

class MyCartMapper @Inject constructor() {

    fun mapBasketMainRemoteToBasketMainDB(basketMainRemote: BasketMainRemote) =
        com.example.cart_screen.data.database.model.BasketMainDB(
            id = basketMainRemote.id.toInt(),
            basket = mapBasketProductRemoteToBasketProductDB(basketMainRemote.basket),
            delivery = basketMainRemote.delivery,
            total = basketMainRemote.total
        )

    private fun mapBasketProductRemoteToBasketProductDB(
        listBasketProductRemote: List<BasketProductRemote>
    ): List<com.example.cart_screen.data.database.model.BasketProductDB> = listBasketProductRemote.map {
        com.example.cart_screen.data.database.model.BasketProductDB(
            id = it.id,
            images = it.images,
            price = it.price,
            title = it.title
        )
    }

    private fun mapBasketProductDBToBasketProduct(
        listBasketProductDB: List<com.example.cart_screen.data.database.model.BasketProductDB>
    ): List<BasketProduct> = listBasketProductDB.map {
        BasketProduct(
            id = it.id,
            images = it.images,
            price = it.price,
            title = it.title
        )
    }

    fun mapListBasketMainDBToListBasketMain(
        listBasketMainDB: List<com.example.cart_screen.data.database.model.BasketMainDB>
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