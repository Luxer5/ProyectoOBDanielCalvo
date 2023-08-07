package com.example.disneyappob.data

import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.model.DisneyModel

interface DisneyRepository {
    suspend fun getDisneyListTreasure(): List<DisneyListModel>
    suspend fun getDisneyListHero(): List<DisneyListModel>
    suspend fun getDisneyListHercules(): List<DisneyListModel>

    suspend fun getDisneyCharacter(id: Int) : DisneyModel
}