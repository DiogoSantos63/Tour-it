package com.tour_it.features

import androidx.room.Room
import com.tour_it.datas.datasModule
import com.tour_it.datas.map.repos.event.EventRepository
import com.tour_it.datas.map.repos.event.EventRepositoryImpl
import com.tour_it.datas.map.repos.hotel.HotelRepository
import com.tour_it.datas.map.repos.hotel.HotelRepositoryImpl
import com.tour_it.datas.map.repos.mock.MockData
import com.tour_it.datas.map.repos.restaurant.RestaurantRepository
import com.tour_it.datas.map.repos.restaurant.RestaurantRepositoryImpl
import com.tour_it.features.authentication.featureAuthenticationModule
import com.tour_it.features.homepage.featureHomePageModule
import com.tour_it.features.map.MapsViewModel
import com.tour_it.features.map.featureMapModule
import com.tour_it.features.productScreen.featureProductModule
import com.tour_it.producer.producerModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val featureModule: Module = module{
    includes(
        producerModule,
        datasModule,
        featureAuthenticationModule,
        featureHomePageModule,
        featureMapModule,
        featureProductModule
    )
    viewModel { MainViewModel(get(), get()) }
}