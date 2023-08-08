package com.example.disneyappob.data

import com.example.disneyappob.data.local.LocalDataSource
import com.example.disneyappob.data.mappers.toCharacterLocal
import com.example.disneyappob.data.mappers.toDisneyListModel
import com.example.disneyappob.data.mappers.toDisneyModel
import com.example.disneyappob.data.remote.RemoteDataSource
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.model.DisneyModel

class DisneyRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : DisneyRepository {
    override suspend fun getDisneyListTreasure(): List<DisneyListModel> = remoteDataSource.getDisneyListTreasure().map {
        it.toDisneyListModel()
    }
    override suspend fun getDisneyListHero(): List<DisneyListModel> = remoteDataSource.getDisneyListHero().map {
        it.toDisneyListModel()
    }
    override suspend fun getDisneyListHercules(): List<DisneyListModel> = remoteDataSource.getDisneyListHercules().map {
        it.toDisneyListModel()
    }

    override suspend fun getDisneyCharacter(id: Int): DisneyModel = remoteDataSource.getDisneyCharacter(id).toDisneyModel()
    override suspend fun insertFav(character: DisneyModel) = localDataSource.insertFav(character.toCharacterLocal())

    override suspend fun deleteFav(character: DisneyModel) = localDataSource.deleteFav(character.toCharacterLocal())
    override suspend fun getAll(): List<DisneyListModel> = localDataSource.getAll().map {
        it.toDisneyListModel()
    }

    override suspend fun checkFav(id: Int): Boolean = localDataSource.checkFav(id)
}