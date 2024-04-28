package com.tour_it.features.splash.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.b_features.R
import com.tour_it.features.MainViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.getViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SplashScreen(
    navController: NavController,
    backStackEntry: NavBackStackEntry
) {
    val viewModel: MainViewModel = getViewModel()
    var index by remember { mutableStateOf(1) }

    LaunchedEffect(Unit) {
        while (true) {
            if(index != 3){
                delay(700)
            } else {
                delay(1500)
            }
            index += 1
        }
    }

    LaunchedEffect(Unit) {
        delay(2900)
        viewModel.loadMockDataToDB()
        viewModel.onAppStart { targetRoute, popUpRoute ->
            navController.navigate(targetRoute) {
                navController.popBackStack(popUpRoute, true)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3B3B3B)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            modifier = Modifier
                .fillMaxSize(),

            painter = if (index == 1) {
                painterResource(id = com.example.e_producer.R.drawable.tour_it_splash_1)
            } else if (index == 2) {
                painterResource(id = com.example.e_producer.R.drawable.tour_it_splash_2)
            } else {
                painterResource(id = com.example.e_producer.R.drawable.tour_it_splash_3)
            },
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}