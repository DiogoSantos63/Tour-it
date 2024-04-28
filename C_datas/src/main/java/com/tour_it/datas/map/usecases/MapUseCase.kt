package com.tour_it.datas.map.usecases

import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.models.products.Location
import com.tour_it.producer.models.products.Restaurant
import com.tour_it.sources.room.entities.EventEntity
import com.tour_it.sources.room.entities.HotelEntity
import com.tour_it.sources.room.entities.RestaurantEntity

fun Restaurant.toRestaurantEntity(): RestaurantEntity {
    return RestaurantEntity(
        name = name,
        cuisine = cuisine,
        location = location,
        rating = rating,
        image = image,
        priceRange = priceRange
    )
}

fun RestaurantEntity.toRestaurant(): Restaurant {
    return Restaurant(
        name = name,
        cuisine = cuisine,
        location = location,
        rating = rating,
        image = image,
        priceRange = priceRange
    )
}

fun Event.toEventEntity(): EventEntity {
    return EventEntity(
        name = name,
        type = type,
        location = location,
        dateTime = dateTime,
        image = image
    )
}

fun EventEntity.toEvent(): Event {
    return Event(
        name = name,
        type = type,
        location = location,
        dateTime = dateTime,
        image = image
    )
}

fun Hotel.toHotelEntity(): HotelEntity {
    return HotelEntity(
        name = name,
        location = location,
        rating = rating,
        image = image
    )
}

fun HotelEntity.toHotel(): Hotel {
    return Hotel(
        name = name,
        location = location,
        rating = rating,
        image = image
    )
}