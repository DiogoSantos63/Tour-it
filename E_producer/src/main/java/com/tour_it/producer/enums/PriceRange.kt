package com.tour_it.producer.enums

enum class PriceRange(val count: String) {
    CHEAP("€"),
    MODERATE("€€"),
    EXPENSIVE("€€€"),
    LUXURY("€€€€");

    override fun toString() = count
}