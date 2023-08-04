package com.example.disneyappob.data.dto

import com.squareup.moshi.Json

data class DataDtoSimple(
    @Json(name = "data") val data: DisneyDto
)
