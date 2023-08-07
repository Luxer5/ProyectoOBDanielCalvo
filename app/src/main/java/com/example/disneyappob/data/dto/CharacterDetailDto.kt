package com.example.disneyappob.data.dto

import com.squareup.moshi.Json

data class CharacterDetailDto (
    @Json(name = "_id") val _id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "imageUrl") val imageUrl: String?,
    @Json(name = "films") val films: List<String>?,
    @Json(name = "tvShows") val tvShows: List<String>?,

)
