package com.tour_it.producer.models.products

data class Event(
    val title: String,
    val type: String,
    val location: Location,
    val dateTime: String
)
