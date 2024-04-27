package com.tour_it.datas.map.repos.location

import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun insertLocation(location: Location)
    suspend fun deleteLocation(location: Location)
    suspend fun getLocations(): Flow<List<Location>>
}