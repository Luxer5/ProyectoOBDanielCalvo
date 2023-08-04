package com.example.disneyappob.data.dto

import com.squareup.moshi.Json

data class DisneyListDto(
    @Json(name = "data") val data: List<CharacterDto>
    )

