package com.tour_it.datas.map.repos.event

import com.tour_it.datas.map.usecases.toEvent
import com.tour_it.datas.map.usecases.toEventEntity
import com.tour_it.producer.models.products.Event
import com.tour_it.sources.room.daos.EventDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EventRepositoryImpl(
    private val dao: EventDao
) : EventRepository {
    override suspend fun insertEvent(event: Event) {
        dao.insertEvent(event.toEventEntity())
    }

    override suspend fun deleteAllEvents() {
        dao.deleteAllEvents()
    }

    override suspend fun getEvents(): Flow<List<Event>> {
       return dao.getAllEvents().map { event ->
           event.map { it.toEvent() }
       }
    }
}