package com.example.tugasfrontend.ui.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tugasfrontend.R
import com.example.tugasfrontend.ui.component.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val blue500 = Color(0xFF3B82F6)
    val blue600 = Color(0xFF2563EB)
    val blue100 = Color(0xFFDBEAFE)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = blue600
                )
            )
        },
        bottomBar = { BottomNavBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(blue100)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Profile Image
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Profile Info Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Bayu Maulana",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = blue600
                    )

                    Text(
                        text = "Politeknik Negeri Batam",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "Teknik Informatika",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "\"Aku, berlutut? cih tidak akan\"",
                        fontSize = 12.sp,
                        color = blue500,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            // Social Media Links Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    SocialMediaItem(
                        icon = R.drawable.ic_instagram,
                        platform = "Instagram",
                        handle = "@bayuzzs"
                    )

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    SocialMediaItem(
                        icon = R.drawable.ic_linkedin,
                        platform = "LinkedIn",
                        handle = "linkedin.com/in/ba-yu-maulana"
                    )

                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    SocialMediaItem(
                        icon = R.drawable.ic_github,
                        platform = "GitHub",
                        handle = "bayuzzs"
                    )
                }
            }
        }
    }
}

@Composable
fun SocialMediaItem(
    icon: Int,
    platform: String,
    handle: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = platform,
            modifier = Modifier.size(24.dp),
            tint = Color(0xFF3B82F6)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = platform,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = handle,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

