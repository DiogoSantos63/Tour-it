package com.tour_it.sources.room.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tour_it.sources.room.converters.Converters
import com.tour_it.sources.room.daos.CartProductsDao
import com.tour_it.sources.room.daos.EventDao
import com.tour_it.sources.room.daos.HotelDao
import com.tour_it.sources.room.daos.RestaurantDao
import com.tour_it.sources.room.daos.UsersDao
import com.tour_it.sources.room.entities.CartProductsEntity
import com.tour_it.sources.room.entities.EventEntity
import com.tour_it.sources.room.entities.HotelEntity
import com.tour_it.sources.room.entities.RestaurantEntity
import com.tour_it.sources.room.entities.UserEntity

@Database(
    entities = [
        EventEntity::class,
        HotelEntity::class,
        RestaurantEntity::class,
        UserEntity::class,
        CartProductsEntity::class,
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class TourItDB: RoomDatabase(){
    abstract fun hotelDao(): HotelDao
    abstract fun eventDao(): EventDao
    abstract fun restaurantDao(): RestaurantDao
    abstract fun usersDao(): UsersDao
    abstract fun cartProductsDao(): CartProductsDao
}