package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.DataDto
import com.example.disneyappob.data.dto.DataDtoSimple
import retrofit2.http.GET
import retrofit2.http.Path

interface DisneyApi{

    @GET("character?page=2")
    suspend fun getDisneyList() : DataDto

    @GET("character/{id}")
    suspend fun getDisneyCharacter(@Path("id") id:Int): DataDtoSimple

}