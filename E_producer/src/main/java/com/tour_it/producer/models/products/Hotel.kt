package com.tour_it.producer.models.products

import com.tour_it.producer.enums.PriceRange

data class Hotel(
    val id: String,
    val name: String,
    val location: Location,
    val rating: Double,
    val image: String,
    val pricePerNight: Double,
    val userPoints: Int,
    val priceRange: PriceRange,
)
