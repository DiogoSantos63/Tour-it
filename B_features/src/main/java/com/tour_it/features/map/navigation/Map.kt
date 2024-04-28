package com.tour_it.features.map.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.android.gms.maps.model.LatLng
import com.tour_it.features.map.ui.MapScreen
import com.tour_it.producer.navigation.NavigationItem

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.map(
    navController: NavController,
){

    navigation(
        startDestination = NavigationItem.MapScreen.route,
        route = NavigationItem.Map.route,
    ){
        composable(
            route = NavigationItem.MapScreen.route,
        ){
            MapScreen(navController, it)
        }
    }
}