package com.example.disneyappob.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.disneyappob.R
import com.example.disneyappob.domain.model.DisneyModel

@Composable
fun DetailItem(
    disney: DisneyModel
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            modifier = Modifier
                .size(250.dp),
            placeholder = painterResource(id = R.drawable.disney_logo),
            error = painterResource(id = R.drawable.disney_logo),
            model = ImageRequest.Builder(LocalContext.current)
                .data(disney.imageUrl)
                .build(),
            contentDescription = ""
        )

        Text(text = "Programas de television:", fontSize = 25.sp)

        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)){
            items(disney.tvShows.size){tvShow ->
                Text(text = disney.tvShows[tvShow])
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(16.dp))

        Text(text = "Peliculas:", fontSize = 25.sp)

        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)){
            items(disney.films.size){ film ->
                Text(text = disney.films[film])
            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(32.dp))
    }
}