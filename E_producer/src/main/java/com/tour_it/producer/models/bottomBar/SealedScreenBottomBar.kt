package com.tour_it.producer.models.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.e_producer.R
import com.tour_it.producer.navigation.NavigationItem

sealed class SealedScreenBottomBar(
    val route: String,
    val title: String?,
    val icon: ImageVector?,
    val image: Int?
) {
    object Home : SealedScreenBottomBar(route=NavigationItem.HomePageScreen.route, title ="Home", Icons.Default.Home, image = null)
    object Points : SealedScreenBottomBar(route=NavigationItem.PointsScreen.route, title= "Points", icon = null, image = R.drawable.coins)
    object Search : SealedScreenBottomBar(route=NavigationItem.SearchScreen.route, title="Search", icon = Icons.Default.Search, image = null)
    object Cart : SealedScreenBottomBar(route=NavigationItem.CartScreen.route, title="Cart", icon = Icons.Default.ShoppingCart, image = null)
}