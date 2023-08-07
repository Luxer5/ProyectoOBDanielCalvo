package com.example.disneyappob.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.disneyappob.R
import com.example.disneyappob.domain.model.DisneyListModel

@Composable
fun ShowCharacterCardList(
    disney: DisneyListModel,
    onClick:(() -> Unit
)){
    Card(modifier = Modifier
        .height(220.dp)
        .width(150.dp)
        .padding(8.dp)
        .clickable { onClick?.invoke() }, )
    {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            AsyncImage(
                modifier = Modifier
                    .size(150.dp),
                placeholder = painterResource(id = R.drawable.disney_logo),
                error = painterResource(id = R.drawable.disney_logo),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(disney.imageUrl)
                    .build(),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))

            Text(text = disney.name, fontSize = 12.sp)
        }
        
    }
}

@Preview
@Composable
fun ShowCharacterCardListPreview(){
    ShowCharacterCardList(DisneyListModel(1,"Nombre personaje",""), {})
}