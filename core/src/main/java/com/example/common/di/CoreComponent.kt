package com.example.common.di

import android.content.Context
import com.example.common.repositories.homeRepositories.AppRepository
import com.example.common.repositories.homeRepositories.AppRepositoryImpl
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreModule::class, DatabaseModule::class,  RepositoryModule::class])
interface CoreComponent {
    fun appContext(): Context

    fun appRepository(): AppRepository
    fun appRepositoryImpl(): AppRepositoryImpl
}