package com.tour_it.datas

import com.tour_it.datas.room.roomModule
import com.tour_it.datas.services.AccountServiceImpl
import com.tour_it.networks.networksModule
import com.tour_it.producer.interfaces.AccountService
import com.tour_it.producer.producerModule
import org.koin.core.module.Module
import org.koin.dsl.module

val datasModule: Module = module {
    includes(
        producerModule,
        networksModule,
        roomModule
    )
    single<AccountService> { AccountServiceImpl() }
}