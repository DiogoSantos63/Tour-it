package com.tour_it.features.productScreen

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val featureProductModule: Module = module{
    viewModel {ProductViewModel(get(), get(), get())}
}