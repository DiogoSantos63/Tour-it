package com.tour_it.datas.map.usecases

import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.models.products.HotelRoom
import com.tour_it.producer.models.products.Location
import com.tour_it.producer.models.products.Restaurant
import com.tour_it.sources.room.entities.EventEntity
import com.tour_it.sources.room.entities.HotelEntity
import com.tour_it.sources.room.entities.LocationEntity
import com.tour_it.sources.room.entities.RestaurantEntity

fun Restaurant.toRestaurantEntity(): RestaurantEntity {
    return RestaurantEntity(
        name = name,
        cuisine = cuisine,
        location = location.toLocationEntity(),
        rating = rating,
        image = image
    )
}

fun RestaurantEntity.toRestaurant(): Restaurant {
    return Restaurant(
        name = name,
        cuisine = cuisine,
        location = location.toLocation(),
        rating = rating,
        image = image
    )
}

fun Event.toEventEntity(): EventEntity {
    return EventEntity(
        name = name,
        type = type,
        location = location.toLocationEntity(),
        dateTime = dateTime,
        image = image
    )
}

fun EventEntity.toEvent(): Event {
    return Event(
        name = name,
        type = type,
        location = location.toLocation(),
        dateTime = dateTime,
        image = image
    )
}

fun Hotel.toHotelEntity(): HotelEntity {
    return HotelEntity(
        name = name,
        location = location.toLocationEntity(),
        rating = rating,
        image = image
    )
}

fun HotelEntity.toHotel(): Hotel {
    return Hotel(
        name = name,
        location = location.toLocation(),
        rating = rating,
        image = image
    )
}

fun Location.toLocationEntity(): LocationEntity {
    return LocationEntity(
        latitude = latitude,
        longitude = longitude,
        street = street,
        city = city,
        state = state,
        postalCode = postalCode,
        country = country
    )
}

fun LocationEntity.toLocation(): Location {
    return Location(
        latitude = latitude,
        longitude = longitude,
        street = street,
        city = city,
        state = state,
        postalCode = postalCode,
        country = country
    )
}