package com.tour_it.features.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tour_it.features.authentication.ui.SignInScreen
import com.tour_it.features.authentication.ui.SignUpScreen
import com.tour_it.producer.navigation.NavigationItem

fun NavGraphBuilder.authentication(navController: NavController){

    navigation(
        startDestination = NavigationItem.SignInScreen.route,
        route = NavigationItem.Authentication.route,
    ){
        composable(
            route = NavigationItem.SignInScreen.route,
        ){
            SignInScreen(navController = navController, navBackStackEntry = it)
        }
        composable(
            route = NavigationItem.SignUpScreen.route
        ){
            SignUpScreen(navController = navController, navBackStackEntry = it)
        }
    }
}