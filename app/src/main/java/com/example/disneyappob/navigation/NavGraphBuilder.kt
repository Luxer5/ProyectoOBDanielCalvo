package com.example.disneyappob.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.disneyappob.presentation.detail.DetailScreen
import com.example.disneyappob.presentation.list.ListScreen
import com.example.disneyappob.presentation.start.StartScreen

fun NavGraphBuilder.addStartScreen(navController: NavController){

    composable(Screen.StartScreen.route){
        StartScreen( onClick = {
            navController.navigate(Screen.ListScreen.route)
        })
    }
}
fun NavGraphBuilder.addListScreen(navController: NavController){

    composable(Screen.ListScreen.route){
        ListScreen{
            navController.navigate(Screen.DetailScreen.route)
        }
    }
}

fun NavGraphBuilder.addDetailScreen(navController: NavController){

    composable(Screen.DetailScreen.route){
        DetailScreen()
    }
}