package com.tour_it.datas

import com.tour_it.datas.service.AccountServiceImpl
import com.tour_it.networks.networksModule
import com.tour_it.producer.interfaces.AccountService
import com.tour_it.producer.producerModule
import org.koin.core.module.Module
import org.koin.dsl.module

val datasModule: Module = module {
    includes(
        producerModule,
        networksModule
    )
    single<AccountService> { AccountServiceImpl() }
}