package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.DisneyListDto
import com.example.disneyappob.data.dto.DisneyCharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DisneyApi{

    @GET("character?page=5")
    suspend fun getDisneyList1() : DisneyListDto
    @GET("character?page=40")
    suspend fun getDisneyList2() : DisneyListDto

    @GET("character/{id}")
    suspend fun getDisneyCharacter(@Path("id") id:Int): DisneyCharacterDto

}