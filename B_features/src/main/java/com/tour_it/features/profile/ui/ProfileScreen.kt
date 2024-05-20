package com.tour_it.features.profile.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.e_producer.R
import com.tour_it.features.authentication.AuthenticationViewModel
import com.tour_it.features.cart.ui.CartComposeEvent
import com.tour_it.features.cart.ui.CartComposeHotel
import com.tour_it.features.cart.ui.CartComposeRestaurant
import com.tour_it.features.productScreen.ProductViewModel
import com.tour_it.producer.components.GenericButton
import com.tour_it.producer.enums.ProductType
import com.tour_it.producer.navigation.NavigationItem
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    backStackEntry: NavBackStackEntry
) {
    val viewModel: AuthenticationViewModel = getViewModel()
    val userName = viewModel.userName.collectAsState()
    val productVM: ProductViewModel = koinViewModel()
    val cartProducts by productVM.mixedCartProductsList.collectAsState()
    val userPoints = productVM.updateUserPoints()


    Scaffold(
        containerColor = Color(0xFF313131),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF313131)
                ),
                title = {

                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = Color.White,
                        )
                    }
                },
                actions = {
                    Text(
                        text = "Settings",
                        color = Color.White
                    )
                },
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sem_t_tulo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text = userName.value,
                            fontSize = 24.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "$userPoints points", fontSize = 16.sp, color = Color.White
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(top = 70.dp, start = 24.dp, end = 24.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = com.example.b_features.R.drawable.ic_book),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(28.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "My Bookings",
                            fontSize = 28.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(
                        thickness = 4.dp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(end = 220.dp, top = 4.dp)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                    ) {
                        Column {
                            LazyColumn(
                                modifier = Modifier
                                    .height(400.dp),
                            ) {
                                items(cartProducts) { product ->
                                    when (product.productType) {
                                        ProductType.HOTEL -> CartComposeHotel(product, false)
                                        ProductType.EVENT -> CartComposeEvent(product, false)
                                        ProductType.RESTAURANT -> CartComposeRestaurant(product, false)
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

        },
        bottomBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(vertical = 50.dp)
                    .padding(start = 40.dp, end = 40.dp)
            ) {
                GenericButton(
                    label = "Log out",
                    size = 40,
                    onClick = {
                        viewModel.onSignOutClick() { _, _ ->
                            navController.popBackStack(NavigationItem.ProfileScreen.route, true)
                            navController.navigate(NavigationItem.SignInScreen.route)
                        }
                    })
                Text(
                    text = "Log out",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(100.dp))
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