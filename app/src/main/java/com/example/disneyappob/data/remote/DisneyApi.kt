package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.DisneyListDto
import com.example.disneyappob.data.dto.DisneyCharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DisneyApi{

    @GET("character?page=2")
    suspend fun getDisneyList() : DisneyListDto

    @GET("character/{id}")
    suspend fun getDisneyCharacter(@Path("id") id:Int): DisneyCharacterDto

}