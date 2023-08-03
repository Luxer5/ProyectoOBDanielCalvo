package com.example.disneyappob.data.remote

import com.example.disneyappob.data.dto.DataDto
import retrofit2.http.GET

interface DisneyApi{

    @GET("character?page=2")
    suspend fun getDisneyList() : List<DataDto>
}