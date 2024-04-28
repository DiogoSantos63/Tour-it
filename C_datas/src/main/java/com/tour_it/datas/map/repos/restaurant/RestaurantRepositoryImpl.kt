package com.tour_it.datas.map.repos.restaurant

import com.tour_it.datas.map.usecases.toRestaurant
import com.tour_it.datas.map.usecases.toRestaurantEntity
import com.tour_it.producer.models.products.Restaurant
import com.tour_it.sources.room.daos.RestaurantDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RestaurantRepositoryImpl(
    private val dao: RestaurantDao
): RestaurantRepository {
    override suspend fun insertRestaurant(restaurant: Restaurant) {
        dao.insertRestaurant(restaurant.toRestaurantEntity())
    }

    override suspend fun deleteAllRestaurants() {
       dao.deleteAllRestaurants()
    }

    override suspend fun getRestaurants(): Flow<List<Restaurant>> {
       return dao.getAllRestaurants().map { restaurant ->
            restaurant.map { it.toRestaurant() }
        }
    }
}