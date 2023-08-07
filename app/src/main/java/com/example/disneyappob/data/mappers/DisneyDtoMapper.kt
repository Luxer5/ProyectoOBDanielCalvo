package com.example.disneyappob.data.mappers

import com.example.disneyappob.data.dto.CharacterDetailDto
import com.example.disneyappob.data.dto.CharacterDto
import com.example.disneyappob.data.local.model.CharacterLocal
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.model.DisneyModel

fun CharacterDto.toDisneyListModel() = DisneyListModel(
    id = _id?: 0,
    name = name?: "",
    imageUrl = imageUrl?: ""
)
fun CharacterDetailDto.toDisneyModel() = DisneyModel(
    id = _id?: 0,
    name = name?: "",
    imageUrl = imageUrl?: "",
    tvShows = tvShows?: listOf(),
    films = films?: listOf()
)
fun DisneyModel.toCharacterLocal() =CharacterLocal(
    id = id,
    name = name,
    imageUrl = imageUrl
)

fun CharacterLocal.toDisneyListModel() = DisneyListModel(
    id = id,
    name = name,
    imageUrl = imageUrl
)