package com.tour_it.features.productScreen.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.b_features.R
import com.tour_it.features.productScreen.ProductViewModel
import com.tour_it.producer.components.GAProfileCircle
import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.navigation.NavigationItem
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductScreenEvent(
    navController: NavController,
    backStackEntry: NavBackStackEntry
) {
    val viewModel = koinViewModel<ProductViewModel>()
    val event = viewModel.event


    Scaffold(
        containerColor = Color(0xFF313131),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF313131) //Add your own color here, just to clarify.
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
                            text = event?.name.orEmpty(),
                            fontSize = 24.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(140.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "teste",
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
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hotel_vila_),
                        contentDescription = null,

                        )
                    Text(
                        text = "R. Abel Dias Urbano, Coimbra",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(end = 200.dp, top = 8.dp)
                    )

                    Text(
                        text = "120 € per night",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(end = 200.dp, top = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Column {
                        Text(
                            text = "Select date",
                            fontSize = 24.sp,
                            color = Color.White
                        )
                        Divider(
                            thickness = 4.dp,
                            color = Color.White,
                            modifier = Modifier.width(120.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SelectDate(modifier = Modifier.fillMaxWidth())

                    }
                }
            }
        },
        bottomBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(vertical = 24.dp)
                    .padding(start = 50.dp)
            ) {
                Text(
                    text = "Add to Cart",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(40.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = Color.White, shape = CircleShape)
                ) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }
            }

        }
    )
}