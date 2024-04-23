package com.tour_it.features.splash.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tour_it.features.splash.ui.SplashScreen
import com.tour_it.producer.navigation.NavigationItem

fun NavGraphBuilder.splash(navController: NavController){

    navigation(
        startDestination = NavigationItem.SplashScreen.route,
        route = NavigationItem.Splash.route,
    ){
        composable(
            route = NavigationItem.SplashScreen.route,
        ){
            SplashScreen(navController, it)
        }
    }
}