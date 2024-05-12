package com.tour_it.features.productScreen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tour_it.features.productScreen.ui.ProductScreenEvent
import com.tour_it.features.productScreen.ui.ProductScreenHotel
import com.tour_it.features.productScreen.ui.ProductScreenRestaurant
import com.tour_it.producer.navigation.NavigationItem

fun NavGraphBuilder.product(navController: NavController){

    navigation(
        startDestination = NavigationItem.ProductScreenHotel.route,
        route = NavigationItem.Product.route,
    ){
        composable(
            route = NavigationItem.ProductScreenHotel.route,
        ){
            ProductScreenHotel(navController = navController, it)
        }
        composable(
            route = NavigationItem.ProductScreenEvent.route,
        ){
            ProductScreenEvent(navController = navController, it)
        }
        composable(
            route = NavigationItem.ProductScreenRestaurant.route,
        ){
            ProductScreenRestaurant(navController = navController, it)
        }
    }
}