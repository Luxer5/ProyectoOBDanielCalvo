package com.example.disneyappob.data.local

import com.example.disneyappob.data.local.model.CharacterLocal

interface LocalDataSource {

    suspend fun insertFav(character: CharacterLocal)

    suspend fun deleteFav(character: CharacterLocal)

    suspend fun getAll(): List<CharacterLocal>

    suspend fun checkFav(id: Int): Boolean
}