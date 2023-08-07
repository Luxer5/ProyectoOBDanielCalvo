package com.example.disneyappob.data

import com.example.disneyappob.data.mappers.toDisneyListModel
import com.example.disneyappob.data.mappers.toDisneyModel
import com.example.disneyappob.data.remote.RemoteDataSource
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.model.DisneyModel

class DisneyRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : DisneyRepository {
    override suspend fun getDisneyList1(): List<DisneyListModel> = remoteDataSource.getDisneyList1().map {
        it.toDisneyListModel()
    }

    override suspend fun getDisneyCharacter(id: Int): DisneyModel = remoteDataSource.getDisneyCharacter(id).toDisneyModel()
}