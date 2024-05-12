package com.tour_it.features.productScreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.b_features.R
import com.tour_it.features.productScreen.ProductViewModel
import com.tour_it.producer.models.products.Event
import com.tour_it.producer.models.products.Hotel
import com.tour_it.producer.models.products.Restaurant
import com.tour_it.producer.navigation.NavigationItem
import org.koin.androidx.compose.getViewModel

@Composable
fun ShowProduct(
    product: Any,
    navController: NavController,
    image: String,
    productName: String,
    pointsValue: String,
    price: String,
    modifier: Modifier = Modifier
) {
    val viewModel: ProductViewModel = getViewModel()
    Column(
        modifier = modifier
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
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = productName,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
        AsyncImage(
            modifier = Modifier
                .height(130.dp)
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10)),
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = pointsValue,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = price,
                color = Color.White
            )
        }
    }
}