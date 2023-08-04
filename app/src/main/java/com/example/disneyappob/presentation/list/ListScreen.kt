package com.example.disneyappob.presentation.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListScreen(
    listScreenViewModel: ListScreenViewModel = koinViewModel(),
    onItemClicked: () -> Unit
) {

    val state = listScreenViewModel.disneyList.observeAsState()

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        val disneyList = state.value

        items(disneyList?.size ?: 0) { i ->
            disneyList?.get(i)?.let { disney ->
                ShowCharacterList(
                    disney = disney,
                    onClick = onItemClicked
                    )
            }
        }
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    //ListScreen()
}
