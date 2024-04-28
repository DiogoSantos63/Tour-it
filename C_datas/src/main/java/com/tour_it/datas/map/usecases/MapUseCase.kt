package com.tour_it.datas.map.usecases

import android.os.Build
import androidx.annotation.RequiresApi
import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.models.products.Location
import com.tour_it.producer.models.products.Restaurant
import com.tour_it.sources.room.entities.EventEntity
import com.tour_it.sources.room.entities.HotelEntity
import com.tour_it.sources.room.entities.RestaurantEntity
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun Restaurant.toRestaurantEntity(): RestaurantEntity {
    return RestaurantEntity(
        name = name,
        cuisine = cuisine,
        location = location,
        rating = rating,
        image = image,
        priceRange = priceRange,
        openingTime = openingTime.toString(),
        closingTime = closingTime.toString(),
        userPoints = userPoints
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun RestaurantEntity.toRestaurant(): Restaurant {
    return Restaurant(
        name = name,
        cuisine = cuisine,
        location = location,
        rating = rating,
        image = image,
        priceRange = priceRange,
        openingTime = LocalTime.parse(openingTime, DateTimeFormatter.ISO_LOCAL_TIME),
        closingTime = LocalTime.parse(closingTime, DateTimeFormatter.ISO_LOCAL_TIME),
        userPoints = userPoints
    )
}

fun Event.toEventEntity(): EventEntity {
    return EventEntity(
        name = name,
        type = type,
        location = location,
        dateTime = dateTime,
        image = image,
        price = price,
        userPoints = userPoints
    )
}

fun EventEntity.toEvent(): Event {
    return Event(
        name = name,
        type = type,
        location = location,
        dateTime = dateTime,
        image = image,
        price = price,
        userPoints = userPoints
    )
}

fun Hotel.toHotelEntity(): HotelEntity {
    return HotelEntity(
        name = name,
        location = location,
        rating = rating,
        image = image,
        pricePerNight = pricePerNight,
        userPoints = userPoints
    )
}

fun HotelEntity.toHotel(): Hotel {
    return Hotel(
        name = name,
        location = location,
        rating = rating,
        image = image,
        pricePerNight = pricePerNight,
        userPoints = userPoints
    )
}