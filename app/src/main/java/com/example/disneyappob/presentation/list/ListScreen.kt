package com.example.disneyappob.presentation.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListScreen() {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally){
        items(15) { ShowCharacterList() }
    }
}

@Preview
@Composable
fun ListScreenPreview(){
    ListScreen()
}
