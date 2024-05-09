package com.tour_it.producer.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.navigation.NavController
import com.tour_it.producer.navigation.NavigationItem

@Composable
fun GABottomBarNavigation(
    navController: NavController
) {
    Box {
        BottomAppBar {
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(NavigationItem.HomePageScreen.route)
                        }
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    BottomNavigationItem(icon = Icons.Default.Home)
                    Text(text = "Home")
                }
                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(NavigationItem.PointsScreen.route)
                        }
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.Center,

                    ) {
                    BottomNavigationItem(icon = Icons.Default.Star)
                    Text(text = "Points")
                }
                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(NavigationItem.SearchScreen.route)
                        }
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    BottomNavigationItem(icon = Icons.Default.Search)
                    Text(text = "Search")
                }
                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(NavigationItem.CartScreen.route)
                        }
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    BottomNavigationItem(icon = Icons.Default.ShoppingCart)
                    Text(text = "Cart")
                }
            }
        }


    }
}


@Composable
private fun BottomNavigationItem(icon: ImageVector) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = Modifier
            .width(24.dp)
            .height(24.dp)
    )
}
