package com.example.disneyappob.presentation.list

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.disneyappob.R
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.ui.theme.DisneyBlueLight

@Composable
fun ShowCharacterCardList(
    disney: DisneyListModel,
    onClick:(() -> Unit
)){
    Card(modifier = Modifier
        .height(200.dp)
        .width(150.dp)
        .padding(4.dp)
        .clickable { onClick?.invoke() }
        .semantics(mergeDescendants = true) {  }
        .clearAndSetSemantics { contentDescription= disney.name },
        elevation = 2.dp )

    {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(DisneyBlueLight),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            AsyncImage(
                modifier = Modifier
                    .size(130.dp)
                    .padding(6.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.disney_logo),
                error = painterResource(id = R.drawable.disney_logo),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(disney.imageUrl)
                    .build(),
                contentDescription = "Imagen de ${disney.name}"
            )

            Spacer(modifier = Modifier.fillMaxWidth().height(12.dp))

            Text(text = disney.name, fontSize = 16.sp, textAlign = TextAlign.Center)
        }
        
    }
}

@Preview
@Composable
fun ShowCharacterCardListPreview(){
    ShowCharacterCardList(DisneyListModel(1,"Nombre personaje",""), {})
}