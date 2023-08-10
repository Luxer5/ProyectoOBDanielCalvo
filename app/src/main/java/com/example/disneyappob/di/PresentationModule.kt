package com.example.disneyappob.di

import com.example.disneyappob.presentation.detail.DetailScreenViewModel
import com.example.disneyappob.presentation.favorite.FavoriteScreen
import com.example.disneyappob.presentation.favorite.FavoriteScreenViewModel
import com.example.disneyappob.presentation.list.ListScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel{ ListScreenViewModel(get(), get(), get()) }

    viewModel{ DetailScreenViewModel(get(), get(), get(), get())}

    viewModel{ FavoriteScreenViewModel(get())}
}