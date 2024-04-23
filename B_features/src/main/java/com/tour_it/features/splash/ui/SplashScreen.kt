package com.tour_it.features.splash.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.tour_it.features.MainViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SplashScreen(
    navController: NavController,
    backStackEntry: NavBackStackEntry
){
    val viewModel: MainViewModel = getViewModel()

    LaunchedEffect(Unit) {
        viewModel.onAppStart { targetRoute, popUpRoute ->
            navController.navigate(targetRoute) {
                navController.popBackStack(popUpRoute, true)
            }
        }
    }

    Text(text = "Olá")
}