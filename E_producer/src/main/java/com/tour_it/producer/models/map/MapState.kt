package com.tour_it.producer.models.map

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.tour_it.producer.json.MapStyle
import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.models.products.Location
import com.tour_it.producer.models.products.Restaurant

data class MapState(
    val properties: MapProperties = MapProperties(
        mapStyleOptions = MapStyleOptions(MapStyle.json)
    ),
    val hotels: List<Hotel> = emptyList(),
    val events: List<Event> = emptyList(),
    val restaurants: List<Restaurant> = emptyList(),
    val isFalloutMap: Boolean = false
)
