package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.CharacterDetailDto
import com.example.disneyappob.data.dto.CharacterDto

interface RemoteDataSource {
    suspend fun getDisneyListTreasure(): List<CharacterDto>
    suspend fun getDisneyListHero(): List<CharacterDto>
    suspend fun getDisneyListHercules(): List<CharacterDto>
    suspend fun getDisneyCharacter(id:Int) : CharacterDetailDto
}