package com.tour_it.features.productScreen.ui

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.b_features.R
import com.tour_it.features.productScreen.ProductViewModel
import com.tour_it.producer.components.GAProfileCircle
import com.tour_it.producer.components.GenericButton
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.navigation.NavigationItem
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductScreenRestaurant(
    navController: NavController,
    backStackEntry: NavBackStackEntry
) {
    val viewModel = koinViewModel<ProductViewModel>()
    val restaurant = viewModel.restaurant

    Scaffold(
        containerColor = Color(0xFF313131),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF313131)
                ),
                title = {
                    Image(
                        painter = painterResource(id = com.example.e_producer.R.drawable.logo_tour_it),
                        contentDescription = null,
                        modifier = Modifier
                            .size(170.dp)
                            .padding(top = 16.dp, start = 16.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate(NavigationItem.ProfileScreen.route) }) {
                        GAProfileCircle(
                            navController = navController,
                            image = com.example.e_producer.R.drawable.sem_t_tulo,
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }
                },
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(top = 100.dp, start = 16.dp, end = 16.dp)
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = restaurant?.name.orEmpty(),
                            maxLines = 1,
                            overflow = TextOverflow.Clip,
                            fontSize = 24.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Row(
                            modifier = Modifier
                                .padding(end = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = restaurant?.cuisine.orEmpty(),
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Divider(
                        thickness = 4.dp,
                        color = Color.White,
                        modifier = Modifier.padding(end = 240.dp)
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth(),
                        model = restaurant?.image.orEmpty(),
                        contentDescription = null,
                    )
                    Text(
                        text = restaurant?.location?.street.orEmpty(),
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(end = 200.dp, top = 8.dp)
                    )

                    Text(
                        text = "${restaurant?.priceRange.toString()} €",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(end = 200.dp, top = 8.dp)
                    )
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                GenericButton(label = "Add to cart", size = 30) {
                    viewModel.calculateDays()
                    if (restaurant != null) {
                        viewModel.addRestaurantToCart(product = restaurant)
                        navController.navigate(NavigationItem.CartScreen.route)
                    }
                }
            }
        }
    )
}