package com.tour_it.datas.room.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tour_it.datas.room.converters.Converters
import com.tour_it.datas.room.daos.EventDao
import com.tour_it.datas.room.daos.HotelDao
import com.tour_it.datas.room.daos.HotelRoomDao
import com.tour_it.datas.room.daos.RestaurantDao
import com.tour_it.datas.room.entities.Event
import com.tour_it.datas.room.entities.Hotel
import com.tour_it.datas.room.entities.HotelRoom
import com.tour_it.datas.room.entities.Restaurant

@Database(
    entities = [
        Event::class,
        Hotel::class,
        HotelRoom::class,
        Restaurant::class
    ],
    version = 1,
)

@TypeConverters(Converters::class)
abstract class TourItDB: RoomDatabase(){

    abstract fun hotelDao(): HotelDao
    abstract fun hotelRoomDao(): HotelRoomDao
    abstract fun eventDao(): EventDao
    abstract fun restaurantDao(): RestaurantDao
}