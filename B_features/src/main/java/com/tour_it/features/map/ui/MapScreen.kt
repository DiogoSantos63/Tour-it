package com.tour_it.features.map.ui

import android.content.Context
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.location.LocationManagerCompat.getCurrentLocation
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.UiSettings
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.tour_it.features.MainViewModel
import com.tour_it.features.map.MapsViewModel
import com.tour_it.producer.components.MapCard
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    navController: NavController,
    backStackEntry: NavBackStackEntry,
) {
    val viewModel = koinViewModel<MapsViewModel>()
    val userLocation: LatLng = viewModel.userLocation.value

    GoogleMap(
        modifier = Modifier
            .fillMaxSize(),
        properties = viewModel.state.properties,
        cameraPositionState = rememberCameraPositionState {
            position = CameraPosition(LatLng(userLocation.latitude, userLocation.longitude), 13f, 0f, 0f)
        },
        uiSettings = MapUiSettings(zoomControlsEnabled = false),
        onMapLongClick = {

        }
    ) {
        Marker(
            state = rememberMarkerState(
                position = LatLng(
                    userLocation.latitude,
                    userLocation.longitude
                )
            )
        )

        viewModel.state.hotels.forEach { hotel ->
            MapCard(
                title = hotel.name,
                description = hotel.rating.toString(),
                imageUrl = hotel.image,
                position = LatLng(hotel.location.latitude, hotel.location.longitude)
            )
        }
        viewModel.state.events.forEach { event ->
            MapCard(
                title = event.name,
                description = event.dateTime,
                imageUrl = event.image,
                position = LatLng(event.location.latitude, event.location.longitude)
            )
        }
    }
}