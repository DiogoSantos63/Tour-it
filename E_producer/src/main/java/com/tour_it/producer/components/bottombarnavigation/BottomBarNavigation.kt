package com.tour_it.producer.components.bottombarnavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.ui.res.painterResource

@Composable
fun GABottomBarNavigation(
    items: List<SealedScreenBottomBar>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
) {
    BottomAppBar {
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(56.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                BottomBarItem(
                    item = item,
                    isSelected = index == selectedIndex,
                    onSelected = { onItemSelected(index) }
                )
                Spacer(modifier = Modifier.width(68.dp))
            }
        }
    }
}

@Composable
private fun BottomBarItem(
    item: SealedScreenBottomBar,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Column(
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


@Preview
@Composable
fun GABottomBarNavigationPreview() {
    val items = listOf(
        SealedScreenBottomBar.Home,
        SealedScreenBottomBar.Search,
        SealedScreenBottomBar.Points,
        SealedScreenBottomBar.Cart
    )
    Surface(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
        GABottomBarNavigation(
            items = items,
            selectedIndex = 0, // Change this to see different items selected
            onItemSelected = {},
        )
    }
}
