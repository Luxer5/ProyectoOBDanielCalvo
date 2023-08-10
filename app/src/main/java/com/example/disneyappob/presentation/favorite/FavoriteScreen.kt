package com.example.disneyappob.presentation.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.disneyappob.R
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

    val favCharactersString = stringResource(R.string.favorite_characters_description)

    Column(modifier = Modifier.fillMaxSize().background(DisneyBlue), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(R.string.my_favorite_characters),
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        LazyVerticalGrid( modifier = Modifier.semantics { contentDescription= favCharactersString },columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp), content = {
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