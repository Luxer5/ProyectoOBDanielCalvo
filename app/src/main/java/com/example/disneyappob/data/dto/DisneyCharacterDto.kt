package com.example.disneyappob.data.dto

import com.squareup.moshi.Json

data class DisneyCharacterDto(
    @Json(name = "data") val data: CharacterDetailDto
)
