package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.CharacterDetailDto
import com.example.disneyappob.data.dto.CharacterDto

class RemoteDataSourceImpl(
    private val disneyApi: DisneyApi
) : RemoteDataSource{
    override suspend fun getDisneyList1(): List<CharacterDto> = disneyApi.getDisneyList1().data
    override suspend fun getDisneyList2(): List<CharacterDto> = disneyApi.getDisneyList2().data
    override suspend fun getDisneyList3(): List<CharacterDto> = disneyApi.getDisneyList3().data
    override suspend fun getDisneyCharacter(id: Int): CharacterDetailDto = disneyApi.getDisneyCharacter(id).data


}