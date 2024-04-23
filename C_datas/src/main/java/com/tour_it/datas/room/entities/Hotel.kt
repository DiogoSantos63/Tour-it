package com.tour_it.datas.room.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tour_it.producer.models.products.Location

@Entity(tableName = "hotels")
data class Hotel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    @Embedded val location: Location,
    val rating: Double,
    @Embedded(prefix = "room_") val hotelRoom: HotelRoom
)