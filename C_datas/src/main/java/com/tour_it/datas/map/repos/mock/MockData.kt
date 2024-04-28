package com.tour_it.datas.map.repos.mock

import android.os.Build
import androidx.annotation.RequiresApi
import com.tour_it.datas.map.usecases.toEventEntity
import com.tour_it.datas.map.usecases.toHotelEntity
import com.tour_it.datas.map.usecases.toRestaurantEntity
import com.tour_it.producer.enums.PriceRange
import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.models.products.Location
import com.tour_it.producer.models.products.Restaurant
import com.tour_it.sources.room.databases.TourItDB
import kotlinx.coroutines.coroutineScope
import java.time.LocalDateTime

class MockData(
    private val database: TourItDB
) {
    suspend fun insertHotels() {
        val hotels = listOf(
            Hotel(
                name = "Hotel Ibis Coimbra Centro",
                location = Location(
                    40.2054220174009,
                    -8.426699967500364,
                    "Avenida Emidio Navarro Nº70",
                    "Coimbra",
                    "Coimbra",
                    "3000-150",
                    "Portugal"
                ),
                rating = 4.0,
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5EIFf3DnerreCBSDs47tYOZtoSKbU7qqCdRRSNtDHZ9lujdlrFbpSADgHZM498ajQ4FM&usqp=CAU"
            )
        )
        database.hotelDao().deleteAllHotels()
        hotels.forEach { hotel ->
            database.hotelDao().insertHotel(hotel.toHotelEntity())
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun insertEvents() {
        val events = listOf(
            Event(
                name = "Queima das Fitas de Coimbra",
                type = "Song Festival",
                location = Location(
                    40.20400034574994,
                    -8.430771560684507,
                    "Praça da canção",
                    "Coimbra",
                    "Coimbra",
                    "3000-150",
                    "Portugal"
                ),
                dateTime = LocalDateTime.of(2024, 5, 24, 23, 30).toString(),
                image = "https://images.impresa.pt/expresso/2023-04-27-281341664_2246515882164408_1294832501802301189_n.jpg-e74db27b"
            )
        )
        database.eventDao().deleteAllEvents()
        events.forEach { event ->
            database.eventDao().insertEvent(event.toEventEntity())
        }
    }

    suspend fun insertRestaurants(){
        val restaurants = listOf(
            Restaurant(
                name = "Praxis",
                cuisine = "Bar, Europeia, Portuguesa",
                location = Location(
                    40.202121618204146,
                    -8.461158796071496,
                    "Rua António Gonçalves ",
                    "Coimbra",
                    "Coimbra",
                    "3040-375",
                    "Portugal"
                ),
                rating = 3.5,
                image = "https://lh3.googleusercontent.com/p/AF1QipPR4LmxNVUuAotjXtwoRyqpsaXyy34oODnCVIjT=s680-w680-h510",
                priceRange = PriceRange.MODERATE
            )
        )
        database.restaurantDao().deleteAllRestaurants()
        restaurants.forEach { restaurant ->
            database.restaurantDao().insertRestaurant(restaurant.toRestaurantEntity())
        }
    }
}

