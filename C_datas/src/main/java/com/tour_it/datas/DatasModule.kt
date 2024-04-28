package com.tour_it.datas

import com.tour_it.datas.map.repos.event.EventRepository
import com.tour_it.datas.map.repos.event.EventRepositoryImpl
import com.tour_it.datas.map.repos.hotel.HotelRepository
import com.tour_it.datas.map.repos.hotel.HotelRepositoryImpl
import com.tour_it.datas.map.repos.mock.MockData
import com.tour_it.datas.map.repos.restaurant.RestaurantRepository
import com.tour_it.datas.map.repos.restaurant.RestaurantRepositoryImpl
import com.tour_it.producer.producerModule
import com.tour_it.sources.sourcesModule
import org.koin.core.module.Module
import org.koin.dsl.module

val datasModule: Module = module {
    includes(
        producerModule,
        sourcesModule,
    )
    single<RestaurantRepository> { RestaurantRepositoryImpl(get()) }
    single<HotelRepository> { HotelRepositoryImpl(get()) }
    single<EventRepository> { EventRepositoryImpl(get()) }
    single { MockData(get()) }
}