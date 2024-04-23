package com.tour_it.features.homepage

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val featureHomePageModule: Module = module {
    viewModel {HomePageViewModel(get())}
}