package com.tour_it.sources.room.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tour_it.producer.models.products.Location

@Entity(tableName = "hotels")
data class HotelEntity(
    @PrimaryKey(autoGenerate = true) val hotelId: Int = 0,
    val name: String,
    @Embedded val location: LocationEntity,
    val rating: Double,
    val image: String
)