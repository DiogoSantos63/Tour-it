package com.tour_it.sources.room.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tour_it.sources.room.converters.Converters
import com.tour_it.sources.room.daos.EventDao
import com.tour_it.sources.room.daos.HotelDao
import com.tour_it.sources.room.daos.LocationDao
import com.tour_it.sources.room.daos.RestaurantDao
import com.tour_it.sources.room.entities.EventEntity
import com.tour_it.sources.room.entities.HotelEntity
import com.tour_it.sources.room.entities.LocationEntity
import com.tour_it.sources.room.entities.RestaurantEntity

@Database(
    entities = [
        EventEntity::class,
        HotelEntity::class,
        RestaurantEntity::class,
        LocationEntity::class
    ],
    version = 1,
)

@TypeConverters(Converters::class)
abstract class TourItDB: RoomDatabase(){
    abstract fun hotelDao(): HotelDao
    abstract fun eventDao(): EventDao
    abstract fun locationDao(): LocationDao
    abstract fun restaurantDao(): RestaurantDao
}