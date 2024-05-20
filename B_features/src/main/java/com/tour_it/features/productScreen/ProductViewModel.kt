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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
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
    private val _mixedCartProductsList = MutableStateFlow<List<CartProductsEntity>>(emptyList())
    private val _selectedStartDate = MutableStateFlow(LocalDate.now())
    private val _selectedEndDate = MutableStateFlow(LocalDate.now())
    private val _days = MutableStateFlow(0)
    val mixedProductsList: StateFlow<List<Any>> get() = _mixedProductsList
    val mixedCartProductsList: StateFlow<List<CartProductsEntity>>get() =  _mixedCartProductsList


    val selectedStartDate = _selectedStartDate
    val selectedEndDate = _selectedEndDate
    val userName = MutableStateFlow("user")
    var hotel: Hotel? = null
    var event: Event? = null
    var restaurant: Restaurant? = null
    init {
        getProductsFromDatabase()
        getAccountUserName()
        updateUserPoints()
        getCartProductsFromDatabase()
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

    fun removeProductCart(id: Int){
        viewModelScope.launch {
            db.cartProductsDao().deleteProduct(id)
        }
        getCartProductsFromDatabase()
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

    fun addHotelToCart(hotel: Hotel, startDate: LocalDate, endDate: LocalDate){
        viewModelScope.launch {
            val product = CartProductsEntity(
                name = hotel.name,
                priceRange = hotel.priceRange,
                image = hotel.image,
                openingTime = startDate.toString(),
                closingTime = endDate.toString(),
                price = hotel.pricePerNight,
                userPoints = hotel.userPoints,
                location = hotel.location,
                productType = ProductType.HOTEL
            )
            db.cartProductsDao().insertProduct(product)
            getCartProductsFromDatabase()
        }
    }

    fun calculateCartProduct(products : List<CartProductsEntity>): Double {
        var total = 0.0

        products.forEach { product ->
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            total += when (product.productType) {
                ProductType.EVENT -> product.price
                ProductType.HOTEL -> {
                    val startDate = LocalDate.parse(product.openingTime, formatter)
                    val endDate = LocalDate.parse(product.closingTime, formatter)
                    val daysDifference = ChronoUnit.DAYS.between(startDate, endDate)
                    daysDifference * product.price
                }
                ProductType.RESTAURANT -> product.price
            }
        }
        return total
    }

    fun calculatePointsProduct(products : List<CartProductsEntity>): Int {
        var points = 0
        products.forEach { product ->
            when (product.productType) {
                ProductType.EVENT -> points += product.userPoints
                ProductType.HOTEL ->  points += product.userPoints
                ProductType.RESTAURANT -> points += product.userPoints
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
            getCartProductsFromDatabase()
        }
    }
    fun addRestaurantToCart(restaurant: Restaurant){
        viewModelScope.launch {
            val product = CartProductsEntity(
                name = restaurant.name,
                priceRange = restaurant.priceRange,
                image = restaurant.image,
                price = 0.0,
                userPoints = restaurant.userPoints,
                location = restaurant.location,
                productType = ProductType.EVENT,
                openingTime = restaurant.openingTime.toString(),
                closingTime = restaurant.closingTime.toString()
            )
            db.cartProductsDao().insertProduct(product)
            getCartProductsFromDatabase()
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

    fun getCartProductsFromDatabase(){
        viewModelScope.launch {
            val cartProducts = db.cartProductsDao().getProducts()
            _mixedCartProductsList.value = cartProducts
        }
    }
}
