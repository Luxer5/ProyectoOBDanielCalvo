package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.DisneyListDto
import com.example.disneyappob.data.dto.DisneyCharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DisneyApi{

    @GET("character?films=Treasure Planet")
    suspend fun getDisneyListTreasure() : DisneyListDto
    @GET("character?films=Big Hero")
    suspend fun getDisneyListHero() : DisneyListDto
    @GET("character?films=Hercules")
    suspend fun getDisneyListHercules() : DisneyListDto

    @GET("character/{id}")
    suspend fun getDisneyCharacter(@Path("id") id:Int): DisneyCharacterDto

}