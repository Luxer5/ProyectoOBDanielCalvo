package com.example.disneyappob.data.dto

import com.squareup.moshi.Json

data class DataDto(
    @Json(name = "data") val data: List<DisneyDto>
    )

