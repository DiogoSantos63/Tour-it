package com.tour_it.producer.models.map

sealed class MapEvent {
    object ToogleFalloutMap: MapEvent()
}