package com.tour_it.features.productScreen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tour_it.features.authentication.ui.SignInScreen
import com.tour_it.features.authentication.ui.SignUpScreen
import com.tour_it.features.productScreen.ui.ProductScreen
import com.tour_it.producer.navigation.NavigationItem

fun NavGraphBuilder.product(navController: NavController){

    navigation(
        startDestination = NavigationItem.ProductScreen.route,
        route = NavigationItem.Product.route,
    ){
        composable(
            route = NavigationItem.ProductScreen.route,
        ){
            ProductScreen(navController = navController, it)
        }
    }
}