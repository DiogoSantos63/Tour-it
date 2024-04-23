package com.tour_it.datas.room

import android.app.Application
import androidx.room.Room
import com.tour_it.datas.room.databases.TourItDB
import org.koin.core.module.Module
import org.koin.dsl.module

val roomModule: Module = module {
    single {
        Room.databaseBuilder(
            get<Application>(),
            TourItDB::class.java,
            "tour_it_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<TourItDB>().hotelRoomDao() }
    single { get<TourItDB>().hotelDao() }
    single { get<TourItDB>().eventDao() }
    single { get<TourItDB>().restaurantDao() }
}