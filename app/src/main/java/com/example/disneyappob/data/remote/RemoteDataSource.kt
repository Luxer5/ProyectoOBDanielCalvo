package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.CharacterDetailDto
import com.example.disneyappob.data.dto.CharacterDto

interface RemoteDataSource {
    suspend fun getDisneyList1(): List<CharacterDto>
    suspend fun getDisneyCharacter(id:Int) : CharacterDetailDto
}