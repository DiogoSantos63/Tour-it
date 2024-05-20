package com.tour_it.features.cart.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tour_it.features.productScreen.ProductViewModel
import com.tour_it.sources.room.entities.CartProductsEntity
import org.koin.androidx.compose.koinViewModel

@Composable
fun CartComposeEvent(
    event: CartProductsEntity,
    isDetail: Boolean
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
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            AsyncImage(
                model = event.image,
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
                        text = event.name,
                        color = Color.Black,
                        maxLines = 2,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = event.location.street,
                        maxLines = 2
                    )
                    Text(
                        text = "${event.dateTime}",
                        maxLines = 2
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End,
                ) {
                    Text(
                        text = "${event.price} €",
                        fontWeight = FontWeight.Bold,
                    )
                    if(isDetail){
                        IconButton(
                            onClick = { viewModel.removeProductCart(event.productId) }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete",
                                tint = Color.Red
                            )
                        }
                    }
                }
            }
        }
    }
}