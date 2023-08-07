package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.CharacterDetailDto
import com.example.disneyappob.data.dto.CharacterDto

class RemoteDataSourceImpl(
    private val disneyApi: DisneyApi
) : RemoteDataSource{
    override suspend fun getDisneyListTreasure(): List<CharacterDto> = disneyApi.getDisneyListTreasure().data
    override suspend fun getDisneyListHero(): List<CharacterDto> = disneyApi.getDisneyListHero().data
    override suspend fun getDisneyListHercules(): List<CharacterDto> = disneyApi.getDisneyListHercules().data
    override suspend fun getDisneyCharacter(id: Int): CharacterDetailDto = disneyApi.getDisneyCharacter(id).data


}