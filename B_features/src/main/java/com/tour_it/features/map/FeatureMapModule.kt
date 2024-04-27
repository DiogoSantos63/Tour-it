package com.tour_it.features.map

import com.tour_it.features.homepage.HomePageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

var featureMapModule: Module = module {
    viewModel { MapsViewModel(get(), get(), get()) }
}