package com.tour_it.features

import com.tour_it.datas.datasModule
import com.tour_it.features.authentication.featureAuthenticationModule
import com.tour_it.features.homepage.featureHomePageModule
import com.tour_it.producer.producerModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val featureModule: Module = module{
    includes(
        producerModule,
        datasModule,
        featureAuthenticationModule,
        featureHomePageModule
    )
    viewModel { MainViewModel(get()) }
}