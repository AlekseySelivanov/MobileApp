package com.example.cart_screen.di

import android.content.Context
import com.example.cart_screen.data.mapper.MyCartMapper
import com.example.cart_screen.data.network.MyCartApiService
import com.example.cart_screen.data.repository.MyCartRepositoryImpl
import com.example.cart_screen.di.modules.*
import com.example.cart_screen.domain.repository.MyCartRepository
import com.example.cart_screen.domain.useCases.GetMyCartUseCase
import com.example.cart_screen.domain.useCases.InsertMyCartToDBUseCase
import dagger.Component

@ModuleScope
@Component(
    modules = [CartModule::class, DatabaseModule::class, NetworkModule::class, RepositoryModule::class]
)
interface CartComponent {
    fun appContext(): Context

    fun MyCartRepository(): MyCartRepository
    fun MyCartRepositoryImpl(): MyCartRepositoryImpl
    fun getMyCartUseCase(): GetMyCartUseCase
    fun insertMyCartToDBUseCase(): InsertMyCartToDBUseCase
    fun myCartMapper(): MyCartMapper
    fun cartService(): MyCartApiService

}