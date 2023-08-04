package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.DataDto
import com.example.disneyappob.data.dto.DisneyDto

interface RemoteDataSource {
    suspend fun getDisneyList(): List<DisneyDto>
    suspend fun getDisneyCharacter(id:Int) : DisneyDto
}