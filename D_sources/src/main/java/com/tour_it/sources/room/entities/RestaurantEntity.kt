package com.tour_it.sources.room.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tour_it.producer.enums.PriceRange
import com.tour_it.producer.models.products.Location

@Entity(tableName = "restaurants")
data class RestaurantEntity(
    @PrimaryKey(autoGenerate = true) val restaurantId: Int = 0,
    val name: String,
    val cuisine: String,
    @Embedded val location: Location,
    val rating: Double,
    val image: String,
    val priceRange: PriceRange,
    val openingTime: String,
    val closingTime: String,
    val userPoints: Int
)
