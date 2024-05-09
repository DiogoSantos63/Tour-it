package com.tour_it.features.map.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.tour_it.features.MainViewModel
import com.tour_it.features.map.MapsViewModel
import com.tour_it.producer.components.GABottomBarNavigation
import com.tour_it.producer.extensions.bitmapDescriptor
import com.tour_it.producer.lists.items
import com.tour_it.producer.navigation.NavigationItem
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    navController: NavController,
    backStackEntry: NavBackStackEntry,
) {
    val context = LocalContext.current
    val mainVieModel = koinViewModel<MainViewModel>()
    val viewModel = koinViewModel<MapsViewModel>()
    val userLocation: LatLng = viewModel.userLocation.value
    var showFilters by remember { mutableStateOf(false) }
    var showHotels by remember { mutableStateOf(true) }
    var showEvents by remember { mutableStateOf(true) }
    var showRestaurants by remember { mutableStateOf(true) }

    val buttonPrimary = ButtonColors(
        MaterialTheme.colorScheme.secondary,
        Color.White,
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.primary
    )
    val buttonSecondary = ButtonColors(
        MaterialTheme.colorScheme.secondary,
        Color.White,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.secondary
    )

    LaunchedEffect(Unit) {
        mainVieModel.loadMockDataToDB()
    }


    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = { navController.navigate(NavigationItem.MapScreen.route) },
                containerColor = Color(0xFFB5B5B5),
                modifier = Modifier
                    .size(70.dp)
                    .offset(x = 0.dp, y = 50.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color(0xFF313131), shape = CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(Icons.Default.LocationOn, contentDescription = "Add", tint = Color.White)
                }
            }
        },
        bottomBar = {
            Surface(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
                GABottomBarNavigation(
                    navController = navController,
                    items = items,
                    selectedIndex = 0,
                    onItemSelected = {},
                )
            }
        },
    ) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                GoogleMap(
                    modifier = Modifier
                        .fillMaxSize(),
                    properties = viewModel.state.properties,
                    cameraPositionState = rememberCameraPositionState {
                        position =
                            CameraPosition(
                                LatLng(userLocation.latitude, userLocation.longitude),
                                13f,
                                0f,
                                0f
                            )
                    },
                    uiSettings = MapUiSettings(zoomControlsEnabled = false),
                ) {
                    Marker(
                        title = "Your current location",
                        icon = bitmapDescriptor(
                            context,
                            com.example.e_producer.R.drawable.baseline_my_location_24
                        ),
                        state = rememberMarkerState(
                            position = LatLng(
                                userLocation.latitude,
                                userLocation.longitude
                            )
                        )
                    )
                    if (showHotels) {
                        viewModel.state.hotels.forEach { hotel ->
                            MapCard(
                                navController = navController,
                                context = context,
                                title = hotel.name,
                                description = hotel.rating.toString(),
                                imageUrl = hotel.image,
                                location = hotel.location,
                                position = LatLng(
                                    hotel.location.latitude,
                                    hotel.location.longitude
                                ),
                                icon = com.example.e_producer.R.drawable.baseline_hotel_24,
                                type = "hotel"
                            )
                        }
                    }
                    if (showEvents) {
                        viewModel.state.events.forEach { event ->
                            MapCard(
                                navController = navController,
                                context = context,
                                title = event.name,
                                description = event.dateTime,
                                location = event.location,
                                imageUrl = event.image,
                                position = LatLng(
                                    event.location.latitude,
                                    event.location.longitude
                                ),
                                icon = com.example.e_producer.R.drawable.baseline_festival_24,
                                type = "event"
                            )
                        }
                    }
                    if (showRestaurants) {
                        viewModel.state.restaurants.forEach { restaurant ->
                            MapCard(
                                navController = navController,
                                context = context,
                                title = restaurant.name,
                                description = restaurant.cuisine,
                                location = restaurant.location,
                                rating = restaurant.rating,
                                imageUrl = restaurant.image,
                                position = LatLng(
                                    restaurant.location.latitude,
                                    restaurant.location.longitude
                                ),
                                icon = com.example.e_producer.R.drawable.baseline_restaurant_24,
                                type = "restaurant"
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Button(onClick = { showFilters = !showFilters }) {
                        Icon(
                            painter = painterResource(id = com.example.e_producer.R.drawable.baseline_filter_list_alt_24),
                            contentDescription = null
                        )
                        Text("Filters")
                    }
                    if (showFilters) {
                        Column {
                            Button(
                                colors = if (showHotels) buttonPrimary else buttonSecondary,
                                onClick = { showHotels = !showHotels }) {
                                Icon(
                                    painter = painterResource(id = com.example.e_producer.R.drawable.baseline_hotel_24),
                                    contentDescription = null
                                )
                            }
                            Button(
                                colors = if (!showEvents) buttonPrimary else buttonSecondary,
                                onClick = { showEvents = !showEvents }) {
                                Icon(
                                    painter = painterResource(id = com.example.e_producer.R.drawable.baseline_festival_24),
                                    contentDescription = null
                                )
                            }
                            Button(
                                colors = if (!showRestaurants) buttonPrimary else buttonSecondary,
                                onClick = { showRestaurants = !showRestaurants }) {
                                Icon(
                                    painter = painterResource(id = com.example.e_producer.R.drawable.baseline_restaurant_24),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}