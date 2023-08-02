package com.example.disneyappob.presentation.list

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.disneyappob.R

@Composable
fun ShowCharacterList() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.disney_logo),
            contentDescription = "Imagen del personaje"
        )
        Spacer(modifier = Modifier.height(100.dp).width(16.dp))

        Text(text = "Nombre del personaje")

    }
}

@Preview
@Composable
fun ShowCharacterPreview() {
    ShowCharacterList()
}