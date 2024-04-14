package com.example.app

import com.example.features.featureModule
import com.example.producer.producerModule
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    includes(
        producerModule,
        featureModule,
    )
}