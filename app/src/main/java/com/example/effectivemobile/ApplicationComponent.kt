package com.example.effectivemobile

import android.app.Application
import com.example.common.di.*
import com.example.effectivemobile.di.DaggerAppComponent

class ApplicationComponent : Application(), CoreComponentProvider {

    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        initCoreComponent()
    }

    private fun initCoreComponent() {
        coreComponent = DaggerCoreComponent
            .builder().coreModule(CoreModule(this))
            .build()
        val component =
            DaggerAppComponent.builder()
                .coreComponent(CoreInjectorHelper.provideCoreComponent(applicationContext))
                .build()
        component.inject(this)
    }

    override fun provideCoreComponent(): CoreComponent {
        if (!this::coreComponent.isInitialized) {
            initCoreComponent()
        }
        return coreComponent
    }
}