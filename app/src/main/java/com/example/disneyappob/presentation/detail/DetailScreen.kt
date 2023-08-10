package com.example.disneyappob.presentation.detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.disneyappob.ui.theme.DisneyBlue
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    id: Int,
    detailScreenViewModel: DetailScreenViewModel = koinViewModel(),
    onBackPressed : () -> Unit
) {

    Log.i("detail",id.toString())

    val disneyState = detailScreenViewModel.disney.observeAsState()
    val stateError = detailScreenViewModel.error.observeAsState()
    detailScreenViewModel.getData(id)

    if(stateError.value?.isNotEmpty() ==true){
        val error =stateError.value
        Box(modifier = Modifier.fillMaxSize()){
            androidx.compose.material.Text(text = error ?: "")
        }
    }

    disneyState.value?.let { disney ->
        Scaffold (
            topBar = {
                TopAppBar(
                    backgroundColor = DisneyBlue,
                    title = {
                        Text(text = "Detalle de ${disney.name}", color = Color.White, fontWeight = FontWeight.Bold )
                    },
                    navigationIcon = {
                        IconButton(
                            modifier= Modifier.semantics {
                                contentDescription= "Atras, Boton Ir al listado de personajes"
                            },
                            onClick = onBackPressed
                        ) {
                            Icon(Icons.Filled.ArrowBack, null, tint = Color.White)
                        }
                        Icons.Filled.ArrowBack
                    }
                )
            }
        )
        {
            DetailItem(disney = disney)
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(5, onBackPressed = {})
}