package com.tour_it.sources.room.converters

import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.tour_it.producer.enums.PriceRange
import org.koin.core.component.KoinComponent

class Converters : KoinComponent{
    @TypeConverter
    fun fromBedTypeList(beds: List<PriceRange>): String = Gson().toJson(beds)

    @TypeConverter
    fun toBedTypeList(bedsString: String): List<PriceRange> =
        Gson().fromJson(bedsString, object : TypeToken<List<PriceRange>>() {}.type)

    @TypeConverter
    fun fromStringList(list: List<String>): String = Gson().toJson(list)

    @TypeConverter
    fun toStringList(listString: String): List<String> =
        Gson().fromJson(listString, object : TypeToken<List<String>>() {}.type)

    @TypeConverter
    fun toPriceRange(value: String): PriceRange = PriceRange.valueOf(value)

    @TypeConverter
    fun fromPriceRange(value: PriceRange): String = value.name

}