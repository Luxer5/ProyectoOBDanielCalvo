package com.example.disneyappob.data

import com.example.disneyappob.domain.model.DisneyModel

interface DisneyRepository {
    suspend fun getDisneyList(): List<DisneyModel>

    suspend fun getDisneyCharacter(id: Int) : DisneyModel
}