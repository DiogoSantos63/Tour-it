package com.tour_it.producer.components

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
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tour_it.producer.models.bottomBar.SealedScreenBottomBar

@Composable
fun GABottomBarNavigation(
    navController: NavController,
    items: List<SealedScreenBottomBar>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
) {
    BottomAppBar {
        Row(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                BottomBarItem(
                    navController = navController,
                    item = item,
                    isSelected = index == selectedIndex,
                    onSelected = { onItemSelected(index) }
                )
            }
        }
    }
}

@Composable
private fun BottomBarItem(
    navController: NavController,
    item: SealedScreenBottomBar,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable {
                navController.navigate(item.route)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (item.icon != null) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp),
            )
        } else if (item.image != null) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
        }
        if (item.title != null) {
            Text(
                text = item.title,
            )
        }
    }
}