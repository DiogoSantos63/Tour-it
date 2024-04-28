package com.tour_it.features.homepage.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.b_features.R
import com.tour_it.producer.components.GABottomBarNavigation
import com.tour_it.producer.components.GATopBar
import com.tour_it.producer.components.ProductCardPoints

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageScreen(
    navController: NavController,
    backStackEntry: NavBackStackEntry
) {

    Scaffold(
        containerColor = Color(0xFF313131),
        topBar = {
            GATopBar()
        },
        content = {
            Column(
                modifier = Modifier.padding(top = 190.dp, start = 16.dp, end = 16.dp)
            ) {
                Column(modifier = Modifier.padding(end = 100.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Welcome",
                            fontSize = 24.sp,
                            color = Color.White
                        )
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append(", ")
                                }
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("user!")
                                }
                            },
                            fontSize = 24.sp,
                            color = Color.White
                        )
                    }
                    Divider(
                        thickness = 4.dp,
                        color = Color.White,
                        modifier = Modifier.padding(end = 130.dp)
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))
                Column {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "Near you",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(150.dp))

                        TextButton(
                            onClick = {},
                            content = {
                                Text(
                                    "See All",
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyRow {
                        items(3) {
                            ProductCardPoints(
                                image = R.drawable.rectangle_18,
                                productName = "O Açude",
                                pointsValue = "4"
                            )
                        }
                    }
                }

                //alterar isto
                Spacer(modifier = Modifier.height(40.dp))
                Column {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "Promos",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(150.dp))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyRow {
                        items(3) {
                            ProductCardPoints(
                                image = R.drawable.rectangle_18,
                                productName = "O Açude",
                                pointsValue = "4"
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            /*Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,

                ) {
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .background(Color.LightGray, shape = CircleShape)
                )

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.Black, shape = CircleShape)
                        .align(Alignment.Center)
                )

                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center),
                    tint = Color.White
                )
            }*/
            Surface(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
                GABottomBarNavigation()
            }
        }
    )
}
