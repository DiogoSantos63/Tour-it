package com.tour_it.features.cart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tour_it.features.authentication.ui.SignInScreen
import com.tour_it.features.authentication.ui.SignUpScreen
import com.tour_it.features.cart.ui.CartScreen
import com.tour_it.producer.navigation.NavigationItem

fun NavGraphBuilder.cart(navController: NavController){

    navigation(
        startDestination = NavigationItem.CartScreen.route,
        route = NavigationItem.Cart.route,
    ){
        composable(
            route = NavigationItem.CartScreen.route,
        ){
            CartScreen(navController = navController, it)
        }
    }
}