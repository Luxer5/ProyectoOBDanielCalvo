package com.example.disneyappob.data.local

import com.example.disneyappob.data.local.model.CharacterLocal

class LocalDataSourceImpl(
    private val disneyDao: DisneyDao
): LocalDataSource {
    override suspend fun insertFav(character: CharacterLocal) = disneyDao.insertFav(character)

    override suspend fun deleteFav(character: CharacterLocal) = disneyDao.deleteFav(character)
    override suspend fun getAll(): List<CharacterLocal> = disneyDao.getAll()

}