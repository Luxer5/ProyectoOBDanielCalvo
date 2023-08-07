package com.example.disneyappob.presentation.detail

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.disneyappob.R
import com.example.disneyappob.domain.model.DisneyModel
import com.example.disneyappob.presentation.list.ListScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    id: Int,
    detailScreenViewModel: DetailScreenViewModel = koinViewModel()
) {

    Log.i("detail",id.toString())

    val disneyState = detailScreenViewModel.disney.observeAsState()
    detailScreenViewModel.getData(id)

    disneyState.value?.let {disney ->
        DetailItem(disney = disney)
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(5)
}