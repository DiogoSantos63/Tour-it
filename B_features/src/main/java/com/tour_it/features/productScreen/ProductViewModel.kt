package com.tour_it.features.productScreen

import androidx.compose.ui.geometry.times
import androidx.compose.ui.unit.times
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tour_it.datas.map.repos.event.EventRepository
import com.tour_it.datas.map.repos.hotel.HotelRepository
import com.tour_it.datas.map.repos.restaurant.RestaurantRepository
import com.tour_it.producer.enums.ProductType
import com.tour_it.producer.interfaces.AccountService
import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.models.products.Restaurant
import com.tour_it.sources.room.databases.TourItDB
import com.tour_it.sources.room.entities.CartProductsEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.time.times

class ProductViewModel(
    private val hotelRepo: HotelRepository,
    private val eventRepo: EventRepository,
    private val restaurantRepo: RestaurantRepository,
    private val db: TourItDB,
    private val accountService: AccountService
) : ViewModel() {
    private val _mixedProductsList = MutableStateFlow<List<Any>>(emptyList())
    private val _mixedCartProductsList = MutableStateFlow<List<Any>>(emptyList())
    private val _selectedStartDate = MutableStateFlow(LocalDate.now())
    private val _selectedEndDate = MutableStateFlow(LocalDate.now())
    private val _days = MutableStateFlow(0)
    private val _cartHotels = MutableStateFlow<List<Hotel>>(listOf())
    private val _cartEvents = MutableStateFlow<List<Event>>(listOf())
    private val _cartRestaurants = MutableStateFlow<List<Restaurant>>(listOf())
    private val _userPoints = MutableStateFlow<Int>(0)
    private val _cartTotal = MutableStateFlow(0.0)
    val mixedProductsList: StateFlow<List<Any>> get() = _mixedProductsList
    val mixedCartProductsList: StateFlow<List<Any>> = _mixedProductsList.asStateFlow()
    val selectedStartDate = _selectedStartDate
    val selectedEndDate = _selectedEndDate
    val userName = MutableStateFlow("user")
    val userPoints = _userPoints.asStateFlow()
    val cartTotal: StateFlow<Double> = _cartTotal.asStateFlow()
    var hotel: Hotel? = null
    var event: Event? = null
    var restaurant: Restaurant? = null
    init {
        getProductsFromDatabase()
        getAccountUserName()
        getCartProductsFromDatabase()
        updateUserPoints()
    }

    private fun getAccountUserName() {
        viewModelScope.launch {
            runCatching {
                accountService.currentUser.collect{ user ->
                    userName.value = user.userName
                }
            }
        }
    }

    fun updateStartDate(date: LocalDate){
        _selectedStartDate.value = date
    }
    fun updateEndDate(date: LocalDate){
        _selectedEndDate.value = date
    }

    fun updateUserPoints(): Int{
        var userPoints = 5
        viewModelScope.launch {
            userName.collect{ name ->
                val points = db.usersDao().getUserPoints(name)
                userPoints = points
            }
        }
        return userPoints
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

    fun addHotelToCart(hotel: Hotel){
        viewModelScope.launch {
            val product = CartProductsEntity(
                name = hotel.name,
                priceRange = hotel.priceRange,
                image = hotel.image,
                price = hotel.pricePerNight,
                userPoints = hotel.userPoints,
                location = hotel.location,
                productType = ProductType.HOTEL
            )
            db.cartProductsDao().insertProduct(product)
        }
    }

    fun calculateCartProduct(products : List<Any>): Double {
        val daysDifference = ChronoUnit.DAYS.between(selectedStartDate.value, selectedEndDate.value).toDouble()
        var total = 0.0

        products.forEach { product ->
            when (product) {
                is Hotel -> total += daysDifference * product.pricePerNight
                is Event -> total += product.price
            }
        }
        return total
    }

    fun calculatePointsProduct(products : List<Any>): Int {
        var points = 0
        products.forEach { product ->
            when (product) {
                is Hotel -> points += product.userPoints
                is Event -> points += product.userPoints
                is Restaurant -> points += product.userPoints
            }
        }
        return points
    }

    fun addEventToCart(event: Event){
        viewModelScope.launch {
            val product = CartProductsEntity(
                name = event.name,
                priceRange = event.priceRange,
                image = event.image,
                price = event.price,
                userPoints = event.userPoints,
                location = event.location,
                productType = ProductType.EVENT,
                dateTime = event.dateTime
            )
            db.cartProductsDao().insertProduct(product)
        }
    }
    fun addRestaurantToCart(restaurant: Restaurant){
        viewModelScope.launch {
            val product = CartProductsEntity(
                name = restaurant.name,
                priceRange = restaurant.priceRange,
                image = restaurant.image,
                userPoints = restaurant.userPoints,
                location = restaurant.location,
                productType = ProductType.EVENT,
                openingTime = restaurant.openingTime.toString(),
                closingTime = restaurant.closingTime.toString()
            )
            db.cartProductsDao().insertProduct(product)
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

    private fun getCartProductsFromDatabase() {
        viewModelScope.launch {
            val cartProducts = db.cartProductsDao().getProducts()
            _mixedCartProductsList.value = cartProducts
        }
    }
}
