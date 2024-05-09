package com.tour_it.features.map.ui

import android.content.Context
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.e_producer.R
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.rememberMarkerState
import com.tour_it.features.productScreen.ProductViewModel
import com.tour_it.producer.extensions.bitmapDescriptor
import com.tour_it.producer.models.products.Location
import com.tour_it.producer.navigation.NavigationItem
import com.tour_it.producer.theme.montserrat
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MapCard(
    navController: NavController,
    context: Context,
    title: String,
    description: String,
    rating: Double = 0.0,
    location: Location,
    imageUrl: String,
    position: LatLng,
    @DrawableRes icon: Int,
    type: String
) {
    val productViewModel = koinViewModel<ProductViewModel>()

    val icon = bitmapDescriptor(
        context = context,
        vectorResId = icon
    )
    val textStyle = TextStyle(
        color = Color.White,
        fontSize = 10.sp,
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold
    )

    val request =
        ImageRequest.Builder(LocalContext.current).data(imageUrl).allowHardware(false).build()

    MarkerInfoWindow(
        icon = icon,
        state = rememberMarkerState(
            position = position
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(250.dp)
                .border(
                    BorderStroke(0.dp, MaterialTheme.colorScheme.primary),
                    RoundedCornerShape(10)
                )
                .clip(RoundedCornerShape(10))
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(end = 8.dp, start = 8.dp, bottom = 8.dp)
                    .fillMaxSize()
            ) {
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(100.dp),
                    model = request,
                    placeholder = painterResource(id = R.drawable.logo_tour_it),
                    contentDescription = null
                )
                if (type == "hotel") {
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = textStyle,
                        text = title
                    )
                    Row() {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            style = textStyle,
                            text = description
                        )
                        Icon(
                            modifier = Modifier
                                .size(12.dp),
                            imageVector = Icons.Default.Star,
                            tint = Color.Yellow,
                            contentDescription = null
                        )
                    }
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = textStyle,
                        text = "${location.street}, ${location.city} ${location.postalCode}",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (type == "event") {
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = textStyle,
                        text = title
                    )
                    Row() {
                        Icon(
                            modifier = Modifier
                                .size(12.dp),
                            imageVector = Icons.Default.DateRange,
                            tint = Color.White,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            style = textStyle,
                            text = LocalDateTime.parse(description)
                                .format(DateTimeFormatter.ISO_LOCAL_DATE)
                        )
                    }
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = textStyle,
                        text = "${location.street}, ${location.city} ${location.postalCode}",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (type == "restaurant") {
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = textStyle,
                        text = title
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = textStyle,
                        text = "$rating"
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        style = textStyle,
                        text = description,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Button(
                    modifier = Modifier,
                    onClick = { navController.navigate(NavigationItem.HomePageScreen.route) }) {
                    Text(
                        modifier = Modifier
                            .clickable {
                                productViewModel.selectedProduct.value = title
                            }
                            .padding(4.dp),
                        style = textStyle,
                        text = "More info"
                    )
                }
            }
        }
    }
}