package com.tour_it.sources.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey(autoGenerate = true) val locationId: Int = 0,
    val latitude: Double,
    val longitude: Double,
    val street: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,
)