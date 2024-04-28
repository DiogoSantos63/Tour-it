package com.tour_it.producer.models.products

import com.tour_it.producer.enums.PriceRange

data class Restaurant(
    val name: String,
    val cuisine: String,
    val location: Location,
    val rating: Double,
    val image: String,
    val priceRange: PriceRange
)
