package com.example.tugasfrontend.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfrontend.model.AppItem
import com.example.tugasfrontend.R

@Composable
fun TrendingAppCard(app: AppItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = app.image),
                contentScale = ContentScale.Crop,
                contentDescription = app.name,
                modifier = Modifier
                    .aspectRatio(20f / 9f)
                    .fillMaxWidth()
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(id = app.icon),
                    contentDescription = app.name,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(shape = RoundedCornerShape(5.dp)),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = app.name,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF3B82F6)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = app.category,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    "Install", color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xFF225CB4))
                        .padding(horizontal = 8.dp)
                        .padding(vertical = 4.dp)
                )
            }
        }
    }
}