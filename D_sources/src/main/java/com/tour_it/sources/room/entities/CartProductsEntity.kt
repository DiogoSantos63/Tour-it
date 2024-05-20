package com.tour_it.sources.room.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tour_it.producer.enums.PriceRange
import com.tour_it.producer.enums.ProductType
import com.tour_it.producer.models.products.Location


@Entity(tableName = "products")
data class CartProductsEntity(
    @PrimaryKey(autoGenerate = true) val productId: Int = 0,
    val name: String,
    @Embedded val location: Location,
    val image: String,
    val userPoints: Int,
    val productType: ProductType,
    val price: Double,
    val type: String? = null,
    val dateTime: String? = null,
    val rating: Double? = null,
    val pricePerNight: Double? = null,
    val cuisine: String? = null,
    val openingTime: String? = null,
    val closingTime: String? = null,
    val priceRange: PriceRange? = null
)