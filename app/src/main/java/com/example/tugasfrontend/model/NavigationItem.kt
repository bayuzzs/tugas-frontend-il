package com.example.tugasfrontend.model

import androidx.annotation.DrawableRes
import com.example.tugasfrontend.ui.navigation.Screen

data class NavigationItem(
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int,
    val route: Screen
)
