package com.tour_it.features.searchScreen.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tour_it.features.authentication.ui.SignInScreen
import com.tour_it.features.authentication.ui.SignUpScreen
import com.tour_it.features.searchScreen.ui.SearchScreen
import com.tour_it.producer.navigation.NavigationItem

fun NavGraphBuilder.search(navController: NavController){

    navigation(
        startDestination = NavigationItem.SearchScreen.route,
        route = NavigationItem.Search.route,
    ){
        composable(
            route = NavigationItem.SearchScreen.route,
        ){
            SearchScreen(navController = navController, it)
        }
    }
}