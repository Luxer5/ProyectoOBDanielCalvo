package com.example.disneyappob.domain.model

data class DisneyModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val films: List<String>,
    val tvShows: List<String>
)
