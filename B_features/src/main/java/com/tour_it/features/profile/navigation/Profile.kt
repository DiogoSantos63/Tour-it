package com.tour_it.features.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tour_it.features.authentication.ui.SignInScreen
import com.tour_it.features.authentication.ui.SignUpScreen
import com.tour_it.features.profile.ui.ProfileScreen
import com.tour_it.producer.navigation.NavigationItem

fun NavGraphBuilder.profile(navController: NavController){

    navigation(
        startDestination = NavigationItem.ProfileScreen.route,
        route = NavigationItem.Profile.route,
    ){
        composable(
            route = NavigationItem.ProfileScreen.route,
        ){
            ProfileScreen(navController = navController, it)
        }
    }
}