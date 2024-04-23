package com.tour_it.networks

import com.tour_it.producer.producerModule
import org.koin.core.module.Module
import org.koin.dsl.module

val networksModule: Module = module {
    includes(
        producerModule
    )
}