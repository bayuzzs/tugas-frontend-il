package com.example.tugasfrontend.model

import androidx.annotation.DrawableRes

data class AppItem(
    val appId: Int,
    val downloadCount: Int,
    val description: String,
    @DrawableRes val icon: Int,
    @DrawableRes val image: Int,
    val name: String,
    val category: String
)
