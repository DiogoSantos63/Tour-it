package com.tour_it.datas.map.repos.hotel

import com.tour_it.datas.map.usecases.toHotel
import com.tour_it.datas.map.usecases.toHotelEntity
import com.tour_it.producer.models.products.Hotel
import com.tour_it.sources.room.daos.HotelDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HotelRepositoryImpl(
    private val dao: HotelDao
) : HotelRepository {
    override suspend fun insertHotel(hotel: Hotel) {
        dao.insertHotel(hotel.toHotelEntity())
    }

    override suspend fun deleteAllHotels() {
        dao.deleteAllHotels()
    }

    override suspend fun getHotels(): Flow<List<Hotel>> {
        return dao.getAllHotels().map { hotel ->
            hotel.map { it.toHotel() }
        }
    }
}