package com.example.tugasfrontend.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugasfrontend.data.DataSource
import com.example.tugasfrontend.model.AppItem
import com.example.tugasfrontend.ui.component.BottomNavBar
import com.example.tugasfrontend.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllAppsScreen(navController: NavController) {
    val (searchText, setSearchText) = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextField(
                        value = searchText,
                        onValueChange = setSearchText,
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Search apps") },
                        colors = TextFieldDefaults.colors(
                            cursorColor = Color(0xFF3B82F6),
                            focusedIndicatorColor = Color(0xFF3B82F6),
                            unfocusedIndicatorColor = Color.Gray.copy(alpha = 0.5f)
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3B82F6) // Tailwind blue-500
                )
            )
        },
        bottomBar = { BottomNavBar(navController) }
    ) { paddingValues ->
        val filteredApps = if (searchText.isNotEmpty()) {
            DataSource.allApps.filter {
                it.name.contains(searchText, ignoreCase = true) ||
                        it.category.contains(searchText, ignoreCase = true)
            }
        } else {
            DataSource.allApps
        }
        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(filteredApps) { app ->
                AppGridItem(
                    app = app,
                    onAppClicked = { navController.navigate(Screen.DetailApp.createRoute(app.appId.toString())) }
                )
            }
        }
    }
}

@Composable
fun AppGridItem(
    app: AppItem,
    onAppClicked: (Int) -> Unit
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onAppClicked(app.appId) },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp).fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = app.icon),
                contentDescription = app.name,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = app.name,
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF3B82F6)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = app.category,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}