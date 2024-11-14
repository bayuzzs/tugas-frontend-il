package com.example.tugasfrontend.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugasfrontend.data.DataSource
import com.example.tugasfrontend.model.AppItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailAppScreen(navController: NavController, appId: Int) {
    val appItem = getAppItemById(appId)

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(appItem.name, color = Color.White) },
                navigationIcon = {
                    IconButton (onClick = { navController.popBackStack() }) {
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
        }
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = appItem.image),
                contentDescription = appItem.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row (
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = appItem.icon),
                    contentDescription = appItem.name,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = appItem.category,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF3B82F6)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${appItem.downloadCount} downloads",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = appItem.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

private fun getAppItemById(appId: Int): AppItem {
    return DataSource.allApps.firstOrNull { it.appId == appId }
        ?: throw IllegalArgumentException("App with ID $appId not found.")
}