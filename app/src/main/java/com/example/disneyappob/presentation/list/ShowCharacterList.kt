package com.example.disneyappob.presentation.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.disneyappob.R
import com.example.disneyappob.domain.model.DisneyModel

@Composable
fun ShowCharacterList(disney: DisneyModel, onClick:(() -> Unit
)) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick?.invoke() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            placeholder = painterResource(id = R.drawable.disney_logo),
            error = painterResource(id = R.drawable.disney_logo),
            model = ImageRequest.Builder(LocalContext.current)
                .data(disney.imageUrl)
                .build(),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(100.dp).width(16.dp))

        Text(text = disney.name)

    }
}

@Preview
@Composable
fun ShowCharacterPreview() {
    ShowCharacterList(DisneyModel(1,"","", listOf(), listOf()), {})
}