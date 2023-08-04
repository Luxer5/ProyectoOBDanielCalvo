package com.example.disneyappob.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object StartScreen : Screen(
        route = "start",
        arguments = emptyList()
    )
    object ListScreen : Screen(
        route = "list",
        arguments = emptyList()
    )
    object DetailScreen : Screen(
        route = "detail",
        arguments = emptyList()
    )
}