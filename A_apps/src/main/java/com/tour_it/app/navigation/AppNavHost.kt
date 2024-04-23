package com.tour_it.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tour_it.features.authentication.navigation.authentication
import com.tour_it.features.homepage.navigation.homePage
import com.tour_it.features.splash.navigation.splash
import com.tour_it.producer.navigation.NavigationItem

@Composable
fun AppNavHost(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Splash.route
    ){
        splash(navController)
        authentication(navController)
        homePage(navController)
    }
}