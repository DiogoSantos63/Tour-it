package com.tour_it.datas.map.repos.restaurant

import com.tour_it.producer.models.products.Restaurant
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    suspend fun insertRestaurant(restaurant: Restaurant)
    suspend fun deleteRestaurant(restaurant: Restaurant)
    suspend fun getRestaurants(): Flow<List<Restaurant>>
}