package com.example.networks

import com.example.producer.producerModule
import org.koin.core.module.Module
import org.koin.dsl.module

val networksModule: Module = module {
    includes(
        producerModule
    )
}