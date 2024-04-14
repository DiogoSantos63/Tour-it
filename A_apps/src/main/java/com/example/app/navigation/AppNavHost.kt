package com.example.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.features.authentication.navigation.authentication
import com.example.producer.navigation.NavigationItem

@Composable
fun AppNavHost(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = NavigationItem.LoginScreen.route
    ){
        authentication(navController)
    }
}