package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.DataDto
import com.example.disneyappob.data.dto.DisneyDto

class RemoteDataSourceImpl(
    private val disneyApi: DisneyApi
) : RemoteDataSource{
    override suspend fun getDisneyList(): List<DisneyDto> = disneyApi.getDisneyList().data
    override suspend fun getDisneyCharacter(id: Int): DisneyDto = disneyApi.getDisneyCharacter(id).data


}