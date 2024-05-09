package com.tour_it.features.homepage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tour_it.features.homepage.ui.HomePageScreen
import com.tour_it.producer.navigation.NavigationItem

fun NavGraphBuilder.homePage(navController: NavController){

    navigation(
        startDestination = NavigationItem.HomePageScreen.route,
        route = NavigationItem.HomePage.route,
    ){
        composable(
            route = NavigationItem.HomePageScreen.route,
        ){
           HomePageScreen(navController, it)
        }
    }
}