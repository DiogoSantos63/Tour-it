package com.tour_it.producer.models.products

data class Location(
    val latitude: Double,
    val longitude: Double,
    val street: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String
)
