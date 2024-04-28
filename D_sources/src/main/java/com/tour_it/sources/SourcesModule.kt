package com.tour_it.sources

import com.tour_it.producer.interfaces.AccountService
import com.tour_it.producer.producerModule
import com.tour_it.sources.firebase.services.AccountServiceImpl
import com.tour_it.sources.room.roomModule
import org.koin.core.module.Module
import org.koin.dsl.module

val sourcesModule: Module = module {
    includes(
        producerModule,
        roomModule
    )
    single<AccountService> { AccountServiceImpl() }
}