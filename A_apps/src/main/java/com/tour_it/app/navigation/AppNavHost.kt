package com.tour_it.app.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.android.gms.maps.model.LatLng
import com.tour_it.features.authentication.navigation.authentication
import com.tour_it.features.homepage.navigation.homePage
import com.tour_it.features.map.navigation.map
import com.tour_it.features.splash.navigation.splash
import com.tour_it.producer.navigation.NavigationItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost(
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Map.route
    ){
        splash(navController)
        authentication(navController)
        homePage(navController)
        map(navController)
    }
}