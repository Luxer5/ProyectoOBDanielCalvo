package com.example.disneyappob.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.disneyappob.R
import com.example.disneyappob.componentes.CircularProgressBar
import com.example.disneyappob.ui.theme.DisneyBlue
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListScreen(
    listScreenViewModel: ListScreenViewModel = koinViewModel(),
    onItemClicked: (Int) -> Unit
) {

    listScreenViewModel.getData()

    val stateTreasure = listScreenViewModel.disneyListTreasure.observeAsState()
    val stateHero = listScreenViewModel.disneyListHero.observeAsState()
    val stateHercules = listScreenViewModel.disneyListHercules.observeAsState()

    val stateError = listScreenViewModel.error.observeAsState()


    if(stateError.value?.isNotEmpty() ==true){
        val error =stateError.value
        Box(modifier = Modifier.fillMaxSize()){
            androidx.compose.material.Text(text = error ?: "")
        }
    }

    if(stateHero.value == null && stateTreasure.value == null && stateHercules.value == null )
        CircularProgressBar(true)
    else{
        Column(
            modifier = Modifier
                .fillMaxSize()

                .background(DisneyBlue)
                .padding(8.dp, bottom = 57.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.my_favorite_films),
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )

            Text(
                text = stringResource(R.string.treasure_planet_text),
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )

            LazyRow(modifier = Modifier.semantics { contentDescription= "El planeta del tesoro" }, verticalAlignment = Alignment.CenterVertically) {
                val disneyList = stateTreasure.value

                items(disneyList?.size ?: 0) { i ->
                    disneyList?.get(i)?.let { disney ->
                        ShowCharacterCardList(
                            disney = disney,
                            onClick = { onItemClicked.invoke(disney.id) }
                        )
                    }
                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )


            Text(
                text = stringResource(R.string.bighero_title),
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )

            LazyRow(modifier = Modifier.semantics { contentDescription= "BigHero 6" },verticalAlignment = Alignment.CenterVertically) {
                val disneyList = stateHero.value

                items(disneyList?.size ?: 0) { i ->
                    disneyList?.get(i)?.let { disney ->
                        ShowCharacterCardList(
                            disney = disney,
                            onClick = { onItemClicked.invoke(disney.id) }
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            Text(
                text = stringResource(R.string.hercules_title),
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
            )

            LazyRow(modifier = Modifier.semantics { contentDescription= "Hércules" },verticalAlignment = Alignment.CenterVertically) {
                val disneyList = stateHercules.value

                items(disneyList?.size ?: 0) { i ->
                    disneyList?.get(i)?.let { disney ->
                        ShowCharacterCardList(
                            disney = disney,
                            onClick = { onItemClicked.invoke(disney.id) }
                        )
                    }
                }
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
        }
    }


}

@Preview
@Composable
fun ListScreenPreview() {
    //ListScreen()
}
