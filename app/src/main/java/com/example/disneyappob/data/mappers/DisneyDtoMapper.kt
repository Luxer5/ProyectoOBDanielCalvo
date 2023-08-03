package com.example.disneyappob.data.mappers

import com.example.disneyappob.data.dto.DisneyDto
import com.example.disneyappob.domain.model.DisneyModel

fun DisneyDto.toDisneyModel() = DisneyModel(
    id = _id,
    name = name,
    imageUrl = imageUrl,
    tvShows = tvShows?: listOf(),
    films = films?: listOf()
)