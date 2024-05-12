package com.tour_it.features.cart.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.b_features.R
import com.tour_it.features.productScreen.ProductViewModel
import com.tour_it.producer.models.products.Hotel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CartComposeHotel(
    hotel: Hotel,
    ) {
    val viewModel = koinViewModel<ProductViewModel>()

    Box(
        modifier = Modifier
            .background(color = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 24.dp)
        ) {
            AsyncImage(
                model = hotel.image,
                contentDescription = null,
                modifier = Modifier
                    .size(width = 84.dp, height = 74.dp)
            )
            Spacer(modifier = Modifier.width(24.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = hotel.name,
                    fontWeight = FontWeight.Bold,
                )
                Text(text = hotel.location.street)
                Text(text = "${viewModel.selectedStartDate} to ${viewModel.selectedEndDate}")
            }

            Spacer(modifier = Modifier.width(28.dp))

            Text(
                text = "${hotel.pricePerNight}",
                fontWeight = FontWeight.Bold,
            )

        }}
}