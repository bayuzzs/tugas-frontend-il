package com.example.tugasfrontend.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tugasfrontend.data.DataSource
import com.example.tugasfrontend.ui.component.AppListItem
import com.example.tugasfrontend.ui.component.BottomNavBar
import com.example.tugasfrontend.ui.component.TrendingAppCard
import com.example.tugasfrontend.ui.navigation.Screen


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val blue500 = Color(0xFF3B82F6)
    val blue600 = Color(0xFF2563EB)
    val allApps = DataSource.allApps
    val trendingApps = DataSource.trendingApps

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Trending Apps", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = blue600
                )
            )
        },
        bottomBar = {
            BottomNavBar(navController)
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Trending Apps pake LazyRow (baris pemalas)
            LazyRow(
                modifier = Modifier
                    .height(250.dp)
                    .padding(16.dp),
                contentPadding = PaddingValues(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(trendingApps) { app ->
                    TrendingAppCard(
                        app = app,
                        onClick = { navController.navigate(Screen.DetailApp.createRoute(app.appId.toString())) })
                }
            }

            // All Apps (LazyColumn)
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(allApps) { app ->
                    AppListItem(
                        app = app,
                        onClick = { navController.navigate(Screen.DetailApp.createRoute(app.appId.toString())) })
                }
            }
        }
    }
}