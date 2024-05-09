package com.tour_it.features.productScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tour_it.datas.datasModule
import com.tour_it.datas.map.repos.event.EventRepository
import com.tour_it.datas.map.repos.hotel.HotelRepository
import com.tour_it.datas.map.repos.restaurant.RestaurantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val hotelRepo: HotelRepository,
    private val eventRepo: EventRepository,
    private val restaurantRepo: RestaurantRepository
) : ViewModel() {
    private val _mixedProductsList = MutableStateFlow<List<Any>>(emptyList())
    val mixedProductsList: StateFlow<List<Any>> get() = _mixedProductsList

    var selectedProduct = mutableStateOf("")

    fun getProductsFromDatabase() {
        viewModelScope.launch {
            val hotels = hotelRepo.getHotels()
            val events = eventRepo.getEvents()
            val restaurants = restaurantRepo.getRestaurants()

            _mixedProductsList.value = listOf<Any>(hotels, events, restaurants)
        }
    }
}