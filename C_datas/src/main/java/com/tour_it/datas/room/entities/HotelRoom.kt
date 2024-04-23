package com.tour_it.datas.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.tour_it.datas.room.converters.Converters
import com.tour_it.producer.enums.BedType

@Entity(tableName = "hotel_rooms")
data class HotelRoom(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val roomNumber: Int,
    val floor: Int,
    @TypeConverters(Converters::class)
    val beds: List<BedType>,
    val numberOfBeds: Int,
    val hasPrivateBathroom: Boolean,
    @TypeConverters(Converters::class)
    val amenities: List<String>
)