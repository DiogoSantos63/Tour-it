package com.tour_it.sources.room.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tour_it.producer.enums.PriceRange
import com.tour_it.producer.models.products.Location

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true) val eventId: Int = 0,
    val name: String,
    val type: String,
    @Embedded val location: Location,
    val dateTime: String,
    val image: String,
    val price: Double,
    val userPoints: Int,
    val priceRange: PriceRange,
)