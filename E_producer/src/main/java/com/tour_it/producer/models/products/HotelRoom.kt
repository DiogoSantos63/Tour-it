package com.tour_it.producer.models.products

import com.tour_it.producer.enums.BedType

data class HotelRoom(
    val roomNumber: Int,
    val floor: Int,
    val beds: List<BedType>,
    val numberOfBeds: Int,
    val hasPrivateBathroom: Boolean,
    val amenities: List<String>,
    val image: String
)