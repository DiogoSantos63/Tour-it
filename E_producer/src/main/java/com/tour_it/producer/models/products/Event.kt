package com.tour_it.producer.models.products

import com.tour_it.producer.enums.PriceRange

data class Event(
    val id: String,
    val name: String,
    val type: String,
    val location: Location,
    val dateTime: String,
    val image: String,
    val price: Double,
    val userPoints: Int,
    val priceRange: PriceRange,
)
