package com.example.disneyappob.presentation.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.disneyappob.presentation.list.ShowCharacterCardList
import com.example.disneyappob.ui.theme.DisneyBlue
import org.koin.androidx.compose.koinViewModel


@Composable
fun FavoriteScreen(
    favoriteScreenViewModel: FavoriteScreenViewModel = koinViewModel(),
    onItemClicked: (Int) -> Unit
) {
    val stateFavorites = favoriteScreenViewModel.disneyListFavorites.observeAsState()

    favoriteScreenViewModel.getData()

    Column(modifier = Modifier.fillMaxSize().background(DisneyBlue)) {
        LazyVerticalGrid( columns = GridCells.Fixed(2), content = {
            val disneyList = stateFavorites.value

            items(disneyList?.size ?: 0){ i->
                disneyList?.get(i)?.let{ disney ->
                    ShowCharacterCardList(
                        disney = disney,
                        onClick = { onItemClicked.invoke(disney.id)}
                    )
                }
            }
        })
    }
    
}