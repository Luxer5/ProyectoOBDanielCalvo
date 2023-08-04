package com.example.disneyappob.data

import com.example.disneyappob.data.mappers.toDisneyModel
import com.example.disneyappob.data.remote.RemoteDataSource
import com.example.disneyappob.domain.model.DisneyModel

class DisneyRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : DisneyRepository {
    override suspend fun getDisneyList(): List<DisneyModel> = remoteDataSource.getDisneyList().map {
        it.toDisneyModel()
    }

    override suspend fun getDisneyCharacter(id: Int): DisneyModel = remoteDataSource.getDisneyCharacter(id).toDisneyModel()
}