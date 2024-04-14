package com.example.datas

import com.example.networks.networksModule
import com.example.producer.producerModule
import org.koin.core.module.Module
import org.koin.dsl.module

val datasModule: Module = module {
    includes(
        producerModule,
        networksModule
    )
}