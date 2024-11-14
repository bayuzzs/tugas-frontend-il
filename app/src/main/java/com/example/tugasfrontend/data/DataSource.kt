package com.example.tugasfrontend.data

import com.example.tugasfrontend.model.NavigationItem
import com.example.tugasfrontend.R
import com.example.tugasfrontend.model.AppItem
import com.example.tugasfrontend.model.GameData
import com.example.tugasfrontend.ui.navigation.Screen


object DataSource {
    val navigationItems: List<NavigationItem> = listOf(
        NavigationItem(R.drawable.ic_home, R.drawable.ic_home_filled, Screen.Home),
        NavigationItem(R.drawable.ic_search, R.drawable.ic_search_filled, Screen.AllAps),
        NavigationItem(R.drawable.ic_profile, R.drawable.ic_profile_filled, Screen.Profile),
    )

    private val gameData = listOf(
        GameData(
            name = "Mobile Legends",
            description = "A multiplayer online battle arena (MOBA) game.",
            icon = R.drawable.ic_mobile_legends,
            image = R.drawable.img_mobile_legends
        ),
        GameData(
            name = "Free Fire",
            description = "A battle royale game with fast-paced action.",
            icon = R.drawable.ic_free_fire,
            image = R.drawable.img_free_fire
        ),
        GameData(
            name = "PUBG Battleground",
            description = "A survival game where players fight to be the last one standing.",
            icon = R.drawable.ic_pubg,
            image = R.drawable.img_pubg
        ),
        GameData(
            name = "Genshin Impact",
            description = "An open-world action role-playing game with gacha mechanics.",
            icon = R.drawable.ic_genshin_impact,
            image = R.drawable.img_genshin_impact
        ),
        GameData(
            name = "Honkai Impact",
            description = "A fast-paced action RPG with a captivating storyline.",
            icon = R.drawable.ic_honkai_impact,
            image = R.drawable.img_honkai_impact
        )
    )

    val allApps: List<AppItem> = List(13) { index ->
        val randomGame = gameData.random()

        AppItem(
            appId = index + 1,
            downloadCount = (450..550).random(),
            description = randomGame.description,
            icon = randomGame.icon,
            image = randomGame.image,
            name = randomGame.name,
            category = "Game | RPG"
        )
    }


    val trendingApps: List<AppItem> = allApps.filter { it.downloadCount > 500 }
}