package com.tour_it.app

import com.tour_it.features.MainViewModel
import com.tour_it.features.featureModule
import com.tour_it.producer.producerModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    includes(
        producerModule,
        featureModule,
    )
}