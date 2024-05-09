package com.tour_it.producer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_producer.R
import com.tour_it.producer.navigation.NavigationItem

@Composable
fun GAProfileCircle(
    navController: NavController,
    image: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .clickable { navController.navigate(NavigationItem.ProfileScreen.route) }
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}