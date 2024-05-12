package com.tour_it.features.productScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tour_it.datas.datasModule
import com.tour_it.datas.map.repos.event.EventRepository
import com.tour_it.datas.map.repos.hotel.HotelRepository
import com.tour_it.datas.map.repos.restaurant.RestaurantRepository
import com.tour_it.features.homepage.ui.compose.ProductHome
import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.models.products.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class ProductViewModel(
    private val hotelRepo: HotelRepository,
    private val eventRepo: EventRepository,
    private val restaurantRepo: RestaurantRepository
) : ViewModel() {
    private val _mixedProductsList = MutableStateFlow<List<Any>>(emptyList())
    private val _selectedStartDate = MutableStateFlow(LocalDate.now())
    private val _selectedEndDate = MutableStateFlow(LocalDate.now())
    private val _days = MutableStateFlow(0)
    private val _cartHotels = MutableStateFlow<List<Hotel>>(listOf())
    val mixedProductsList: StateFlow<List<Any>> get() = _mixedProductsList
    val cartHotels = _cartHotels.asStateFlow()
    val selectedStartDate = _selectedStartDate
    val selectedEndDate = _selectedEndDate


    var hotel: Hotel? = null
    var event: Event? = null
    var restaurant: Restaurant? = null
    init {
        getProductsFromDatabase()
    }

    fun updateStartDate(date: LocalDate){
        _selectedStartDate.value = date
    }
    fun updateEndDate(date: LocalDate){
        _selectedEndDate.value = date
    }

    private fun getProductsFromDatabase() {
        viewModelScope.launch {
            combine(
                hotelRepo.getHotels(),
                eventRepo.getEvents(),
                restaurantRepo.getRestaurants()
            ) { hotels, events, restaurants ->
                mutableListOf<Any>().apply {
                    addAll(hotels)
                    addAll(events)
                    addAll(restaurants)
                }
            }.collect { combinedList ->
                _mixedProductsList.value = combinedList
                hotel = combinedList.filterIsInstance<Hotel>().firstOrNull()
                event = combinedList.filterIsInstance<Event>().firstOrNull()
                restaurant = combinedList.filterIsInstance<Restaurant>().firstOrNull()
            }
        }
    }

    fun calculateDays() {
        val days = if (selectedStartDate.value.isBefore(selectedEndDate.value)) {
            ChronoUnit.DAYS.between(selectedStartDate.value, selectedEndDate.value)
        } else {
            0L
        }

        _days.value = days.toInt()
    }
    fun addHotelToCart(product: Hotel){

    }
    fun addEventToCart(product: Event){

    }
    fun addRestaurantToCart(product: Restaurant){

    }

}