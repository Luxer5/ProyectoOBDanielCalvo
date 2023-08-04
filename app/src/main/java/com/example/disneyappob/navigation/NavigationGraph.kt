package com.example.disneyappob.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph(){
    val navController = rememberNavController()

    NavHost( //FRagment container view
        navController = navController,
        startDestination = Screen.StartScreen.route, //igual que el start Destination
    ){
        addStartScreen(navController)
        addListScreen(navController)
        addDetailScreen(navController)

    }
}