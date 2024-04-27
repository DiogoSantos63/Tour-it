package com.tour_it.features.map

import android.location.Location
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.tour_it.datas.map.repos.event.EventRepository
import com.tour_it.datas.map.repos.hotel.HotelRepository
import com.tour_it.datas.map.repos.restaurant.RestaurantRepository
import com.tour_it.producer.models.map.MapEvent
import com.tour_it.producer.models.map.MapState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class MapsViewModel(
    private val hotelRepo: HotelRepository,
    private val eventRepo: EventRepository,
    private val restaurantRepo: RestaurantRepository
): ViewModel() {
    var userLocation = mutableStateOf<LatLng>(LatLng(40.2033, -8.4103))
    var state by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            hotelRepo.getHotels().collectLatest { hotels ->
                eventRepo.getEvents().collectLatest { events ->
                    restaurantRepo.getRestaurants().collectLatest { restaurants ->
                        state = state.copy(
                            hotels = hotels,
                            events = events,
                            restaurants = restaurants,
                        )
                    }
                }
            }
        }
    }

    fun updateLocation(latitude: Double, longitude: Double) {
       userLocation.value = LatLng(latitude, longitude)
    }
    fun onEvent(event: MapEvent){
        when(event){
            is MapEvent.ToogleFalloutMap -> {
                state = state.copy(
                    isFalloutMap = !state.isFalloutMap
                )
            }
        }
    }
}