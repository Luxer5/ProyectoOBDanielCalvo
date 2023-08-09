package com.example.disneyappob.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.disneyappob.presentation.detail.DetailScreen
import com.example.disneyappob.presentation.list.ListScreen
import com.example.disneyappob.presentation.start.LoginScreen
import com.example.disneyappob.presentation.start.StartScreen

fun NavGraphBuilder.addStartScreen(navController: NavController){

    composable(Screen.StartScreen.route){
        StartScreen( onClick = {
            navController.navigate(Screen.ListScreen.route)
        })
    }
}
fun NavGraphBuilder.addLoginScreen(navController: NavController){

    composable(Screen.LoginScreen.route){
        LoginScreen( onClick = {
            navController.navigate(Screen.ListScreen.route)
        })
    }
}
fun NavGraphBuilder.addListScreen(navController: NavController){

    composable(Screen.ListScreen.route){
        ListScreen{disneyId ->
            navController.navigate("${Screen.DetailScreen.route}/$disneyId")
        }
    }
}

fun NavGraphBuilder.addDetailScreen(navController: NavController){

    composable(
        route= Screen.DetailScreen.route + "/{disneyId}",
        arguments = Screen.DetailScreen.arguments
    ){navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getInt("disneyId") ?: 0
        DetailScreen(id = id, onBackPressed = {navController.popBackStack()})
    }
}