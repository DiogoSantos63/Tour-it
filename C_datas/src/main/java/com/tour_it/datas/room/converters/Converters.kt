package com.tour_it.datas.room.converters

import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.tour_it.producer.enums.BedType
import org.koin.core.component.KoinComponent

class Converters : KoinComponent{
    @TypeConverter
    fun fromBedTypeList(beds: List<BedType>): String = Gson().toJson(beds)

    @TypeConverter
    fun toBedTypeList(bedsString: String): List<BedType> =
        Gson().fromJson(bedsString, object : TypeToken<List<BedType>>() {}.type)

    @TypeConverter
    fun fromStringList(list: List<String>): String = Gson().toJson(list)

    @TypeConverter
    fun toStringList(listString: String): List<String> =
        Gson().fromJson(listString, object : TypeToken<List<String>>() {}.type)

}