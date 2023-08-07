package com.example.disneyappob.data

import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.model.DisneyModel

interface DisneyRepository {
    suspend fun getDisneyList1(): List<DisneyListModel>
    suspend fun getDisneyList2(): List<DisneyListModel>

    suspend fun getDisneyCharacter(id: Int) : DisneyModel
}