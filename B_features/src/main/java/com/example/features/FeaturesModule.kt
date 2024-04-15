package com.example.features

import com.example.datas.datasModule
import com.example.features.authentication.featureAuthenticationModule
import com.example.features.profile.featureProfileModule
import com.example.producer.producerModule
import org.koin.core.module.Module
import org.koin.dsl.module

val featureModule: Module = module{
    includes(
        producerModule,
        datasModule,
        featureAuthenticationModule,
        featureProfileModule
    )
}