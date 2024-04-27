package com.tour_it.datas.map.repos.location

import com.tour_it.datas.map.usecases.toLocation
import com.tour_it.datas.map.usecases.toLocationEntity
import com.tour_it.producer.models.products.Location
import com.tour_it.sources.room.daos.LocationDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocationRepositoryImpl(
    private val dao: LocationDao
) : LocationRepository {
    override suspend fun insertLocation(location: Location) {
      dao.insertLocation(location.toLocationEntity())
    }

    override suspend fun deleteLocation(location: Location) {
        dao.deleteLocation(location.toLocationEntity())
    }

    override suspend fun getLocations(): Flow<List<Location>> {
        return dao.getAllLocations().map { location ->
            location.map { it.toLocation() }
        }
    }
}