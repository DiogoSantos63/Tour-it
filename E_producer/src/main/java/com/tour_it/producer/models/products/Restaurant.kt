package com.tour_it.producer.models.products

data class Restaurant(
    val name: String,
    val cuisine: String,
    val location: Location,
    val rating: Double,
    val image: String
)
