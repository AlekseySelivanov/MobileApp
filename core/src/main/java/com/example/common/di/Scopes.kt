package com.example.common.di

import javax.inject.Scope

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class Screen

@Scope
@Retention
annotation class ModuleScope

@Scope
@Retention
annotation class MainScope