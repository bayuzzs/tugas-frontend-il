package com.example.tugasfrontend.model

import androidx.annotation.DrawableRes

data class GameData(
    val name: String,
    val description: String,
    @DrawableRes val icon: Int,
    @DrawableRes val image: Int
)
