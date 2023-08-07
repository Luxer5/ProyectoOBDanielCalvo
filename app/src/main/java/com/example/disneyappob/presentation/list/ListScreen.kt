package com.example.disneyappob.presentation.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListScreen(
    listScreenViewModel: ListScreenViewModel = koinViewModel(),
    onItemClicked: (Int) -> Unit
) {

    listScreenViewModel.getData()

    val stateTreasure = listScreenViewModel.disneyListTreasure.observeAsState()
    val stateHero = listScreenViewModel.disneyListHero.observeAsState()
    val stateHecules = listScreenViewModel.disneyListHercules.observeAsState()
    val stateFavorites = listScreenViewModel.disneyListFavorites.observeAsState()

    /*LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        val disneyList = state.value

        items(disneyList?.size ?: 0) { i ->
            disneyList?.get(i)?.let { disney ->
                ShowCharacterList(
                    disney = disney,
                    onClick = {onItemClicked.invoke(disney.id)}
                )
            }
        }
    }*/
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Mis peliculas favoritas:", fontSize = 30.sp)

        Text(text = "El planeta del Tesoro", fontSize = 20.sp)
        
        LazyRow(verticalAlignment = Alignment.CenterVertically) {
            val disneyList = stateTreasure.value

            items(disneyList?.size ?: 0) { i ->
                disneyList?.get(i)?.let { disney ->
                    ShowCharacterCardList(
                        disney = disney,
                        onClick = {onItemClicked.invoke(disney.id)}
                    )
                }
            }
        }


        Text(text = "BigHero 6", fontSize = 20.sp)

        LazyRow(verticalAlignment = Alignment.CenterVertically) {
            val disneyList = stateHero.value

            items(disneyList?.size ?: 0) { i ->
                disneyList?.get(i)?.let { disney ->
                    ShowCharacterCardList(
                        disney = disney,
                        onClick = {onItemClicked.invoke(disney.id)}
                    )
                }
            }
        }
        Text(text = "Hercules", fontSize = 20.sp)

        LazyRow(verticalAlignment = Alignment.CenterVertically) {
            val disneyList = stateHecules.value

            items(disneyList?.size ?: 0) { i ->
                disneyList?.get(i)?.let { disney ->
                    ShowCharacterCardList(
                        disney = disney,
                        onClick = {onItemClicked.invoke(disney.id)}
                    )
                }
            }
        }
        Text(text = "Favoritos", fontSize = 20.sp)

        LazyRow(verticalAlignment = Alignment.CenterVertically) {
            val disneyList = stateFavorites.value

            items(disneyList?.size ?: 0) { i ->
                disneyList?.get(i)?.let { disney ->
                    ShowCharacterCardList(
                        disney = disney,
                        onClick = {onItemClicked.invoke(disney.id)}
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun ListScreenPreview() {
    //ListScreen()
}
