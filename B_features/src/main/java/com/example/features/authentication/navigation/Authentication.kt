package com.example.features.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.features.authentication.ui.LoginScreen
import com.example.producer.navigation.NavigationItem

fun NavGraphBuilder.authentication(navController: NavController){

    navigation(
        startDestination = NavigationItem.Authentication.route,
        route = NavigationItem.LoginScreen.route,
    ){
        composable(
            route = NavigationItem.Authentication.route,
        ){
            LoginScreen(navController, it)
        }
    }
}