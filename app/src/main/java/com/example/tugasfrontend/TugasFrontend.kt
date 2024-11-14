package com.example.tugasfrontend

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasfrontend.ui.navigation.Screen
import com.example.tugasfrontend.ui.screen.AllAppsScreen
import com.example.tugasfrontend.ui.screen.DetailAppScreen
import com.example.tugasfrontend.ui.screen.HomeScreen
import com.example.tugasfrontend.ui.screen.ProfileScreen

@Composable
fun TugasFrontendApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.AllAps.route) { AllAppsScreen(navController)}
        composable(
            route = Screen.DetailApp.route,
            arguments = listOf(navArgument("appId") { type = NavType.StringType })
        ) { backStackEntry ->
            // Retrieve appId from arguments
            val appId = backStackEntry.arguments?.getString("appId") ?: ""
            DetailAppScreen(navController = navController, appId = appId.toInt())
        }

    }
}
