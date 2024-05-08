package com.tour_it.features.searchScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.b_features.R
import com.tour_it.features.productScreen.compose.ShowProduct
import com.tour_it.producer.components.bottombarnavigation.GABottomBarNavigation
import com.tour_it.producer.components.GAProfileCircle
import com.tour_it.producer.components.bottombarnavigation.items


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
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
                navigationIcon = {},
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        GAProfileCircle(
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
                Column(modifier = Modifier.padding(end = 100.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search, contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 30.sp
                                    )
                                ) {
                                    append("Search")
                                }
                            },
                            fontSize = 40.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(
                        thickness = 4.dp,
                        color = Color(0xFFB5B5B5),
                        modifier = Modifier.padding(end = 130.dp)
                    )
                }
                Spacer(modifier = Modifier.height(28.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                ) {
                    items(9) { index ->
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                            ShowProduct(
                                image = R.drawable.rectangle_18,
                                productName = "O Açude",
                                pointsValue = "€€",
                                price = "4.2"
                            )
                        }
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = { },
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
                    items = items,
                    selectedIndex = 0,
                    onItemSelected = {},
                )
            }
        },
    )

}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}