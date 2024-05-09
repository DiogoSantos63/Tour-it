package com.tour_it.features.pointsScreen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tour_it.features.cart.ui.CartScreen
import com.tour_it.features.pointsScreen.PointsScreen
import com.tour_it.producer.navigation.NavigationItem

fun NavGraphBuilder.points(navController: NavController){

    navigation(
        startDestination = NavigationItem.PointsScreen.route,
        route = NavigationItem.Points.route,
    ){
        composable(
            route = NavigationItem.PointsScreen.route,
        ){
            PointsScreen(navController = navController, it)
        }
    }
}