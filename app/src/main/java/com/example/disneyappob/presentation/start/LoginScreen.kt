package com.example.disneyappob.presentation.start

import android.content.Context
import android.view.LayoutInflater
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.disneyappob.databinding.LoginScreenBinding

@Composable
fun LoginScreen(
    onClick:() -> Unit
){
    AndroidViewBinding(factory = LoginScreenBinding::inflate){
        btnLogin.setOnClickListener {
            onClick()
        }
    }

}