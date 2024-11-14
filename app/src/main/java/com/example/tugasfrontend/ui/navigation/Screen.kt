package com.example.tugasfrontend.ui.navigation

sealed class Screen(val route: String) {
    data object Profile : Screen("profile")
    data object Home : Screen("home")
    data object AllAps : Screen("all_aps")
    data object DetailApp : Screen("app/{appId}") {
        fun createRoute(appId: String) = "app/$appId"
    }
}