package com.tour_it.producer.models.products

data class Hotel(
    val name: String,
    val location: Location,
    val rating: Double,
    val image: String,
    val pricePerNight: Double,
    val userPoints: Int
)
