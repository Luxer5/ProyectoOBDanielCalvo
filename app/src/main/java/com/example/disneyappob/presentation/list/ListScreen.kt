package com.example.disneyappob.presentation.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListScreen(
    listScreenViewModel: ListScreenViewModel = koinViewModel(),
    onItemClicked: (Int) -> Unit
) {

    val state1 = listScreenViewModel.disneyList1.observeAsState()
    val state2 = listScreenViewModel.disneyList2.observeAsState()
    val state3 = listScreenViewModel.disneyList3.observeAsState()

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
    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        LazyRow(verticalAlignment = Alignment.CenterVertically) {
            val disneyList = state1.value

            items(disneyList?.size ?: 0) { i ->
                disneyList?.get(i)?.let { disney ->
                    ShowCharacterCardList(
                        disney = disney,
                        onClick = {onItemClicked.invoke(disney.id)}
                    )
                }
            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))

        LazyRow(verticalAlignment = Alignment.CenterVertically) {
            val disneyList = state2.value

            items(disneyList?.size ?: 0) { i ->
                disneyList?.get(i)?.let { disney ->
                    ShowCharacterCardList(
                        disney = disney,
                        onClick = {onItemClicked.invoke(disney.id)}
                    )
                }
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))

        LazyRow(verticalAlignment = Alignment.CenterVertically) {
            val disneyList = state3.value

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
