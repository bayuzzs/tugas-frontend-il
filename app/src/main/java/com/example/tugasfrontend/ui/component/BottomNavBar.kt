package com.example.tugasfrontend.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugasfrontend.data.DataSource
import com.example.tugasfrontend.model.NavigationItem
import com.example.tugasfrontend.ui.navigation.Screen
import com.example.tugasfrontend.ui.navigation.getCurrentRoute

@Composable
fun BottomNavBar(navController: NavController, modifier: Modifier = Modifier) {
    val currentRoute = navController.getCurrentRoute()
    val navigationItems = DataSource.navigationItems

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(Color.White)
            .height(IntrinsicSize.Max)
            .fillMaxWidth()
            .padding(WindowInsets.navigationBars.asPaddingValues())
            .padding(vertical = 8.dp)
    ) {
        navigationItems.forEach { item ->
            NavItem(
                navigationItem = item,
                selected = item.route.route == currentRoute,
                navigationOnClick = { navController.navigate(item.route.route) }
            )
        }
    }
}

@Composable
fun NavItem(
    navigationItem: NavigationItem,
    selected: Boolean,
    navigationOnClick: () -> Unit
) {
    IconButton(onClick = navigationOnClick) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(IntrinsicSize.Min)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(if (selected) navigationItem.selectedIcon else navigationItem.icon),
                contentDescription = null,
                tint = if (selected) Color(0xFF7C19B9) else Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            if (selected) {
                Spacer(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .background(
                            color = Color(0xFF7C19B9),
                            shape = RoundedCornerShape(50)
                        )
                        .height(4.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}