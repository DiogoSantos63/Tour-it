package com.tour_it.producer.models.products

data class Event(
    val name: String,
    val type: String,
    val location: Location,
    val dateTime: String,
    val image: String
)
