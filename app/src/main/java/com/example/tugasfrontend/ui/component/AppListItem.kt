package com.example.tugasfrontend.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfrontend.model.AppItem
import com.example.tugasfrontend.R

@Composable
fun AppListItem(app: AppItem, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(12.dp)
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = app.icon),
                contentDescription = app.name,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(10.dp)),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = app.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = app.category,
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
        Icon(
            imageVector = Icons.Default.ArrowForwardIos,
            contentDescription = "Navigate",
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
    }
}