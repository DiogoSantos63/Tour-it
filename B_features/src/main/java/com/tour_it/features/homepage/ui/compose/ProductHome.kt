package com.tour_it.features.homepage.ui.compose

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.b_features.R
import com.tour_it.features.productScreen.ProductViewModel
import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.models.products.Restaurant
import com.tour_it.producer.navigation.NavigationItem

@Composable
fun ProductHome(
    product: Any,
    navController: NavController,
    viewModel: ProductViewModel,
    productID: String,
    image: String,
    productName: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .clickable {
                when(product){
                    is Hotel ->  {
                        navController.navigate(NavigationItem.ProductScreenHotel.route)
                        viewModel.hotel = product
                    }
                    is Event -> {
                        navController.navigate(NavigationItem.ProductScreenEvent.route)
                        viewModel.event = product
                    }
                    is Restaurant -> {
                        navController.navigate(NavigationItem.ProductScreenRestaurant.route)
                        viewModel.restaurant = product
                    }
                }

            }
            .width(140.dp)
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10)),
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = productName,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .fillMaxWidth(),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}