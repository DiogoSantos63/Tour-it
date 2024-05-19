package com.tour_it.features.authentication

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val featureAuthenticationModule: Module = module {
    viewModel { AuthenticationViewModel(get(), get()) }
}