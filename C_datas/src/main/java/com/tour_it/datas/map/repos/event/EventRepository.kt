package com.tour_it.datas.map.repos.event

import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import kotlinx.coroutines.flow.Flow

interface EventRepository{
    suspend fun insertEvent(event: Event)
    suspend fun deleteAllEvents()
    suspend fun getEvents(): Flow<List<Event>>
}