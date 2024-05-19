package com.tour_it.features.cart.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    val startDate = viewModel.selectedStartDate.collectAsState()
    val endDate = viewModel.selectedEndDate.collectAsState()
    Box(
        modifier = Modifier
            .background(color = Color.White)
            .padding(8.dp)
            .clip(RoundedCornerShape(20.dp))
            .width(400.dp)
            .height(600.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            AsyncImage(
                model = hotel.image,
                contentDescription = null,
                modifier = Modifier
                    .size(width = 84.dp, height = 74.dp)
            )
            Spacer(modifier = Modifier.width(24.dp))
            Row(){
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(200.dp)
                ) {
                    Text(
                        text = hotel.name,
                        color = Color.Black,
                        maxLines = 2,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = hotel.location.street,
                        maxLines = 2
                    )
                    Text(
                        text = "From ${startDate.value} to ${endDate.value}",
                        maxLines = 2
                    )
                }
                Text(
                    text = "${hotel.pricePerNight} €",
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}