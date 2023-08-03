package com.example.disneyappob.di

import com.example.disneyappob.presentation.list.ListScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel{ ListScreenViewModel(get()) }
}