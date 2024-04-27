package com.tour_it.datas.map.repos.hotel

import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.models.products.Restaurant
import kotlinx.coroutines.flow.Flow

interface HotelRepository {
    suspend fun insertHotel(hotel: Hotel)
    suspend fun deleteAllHotels()
    suspend fun getHotels(): Flow<List<Hotel>>
}