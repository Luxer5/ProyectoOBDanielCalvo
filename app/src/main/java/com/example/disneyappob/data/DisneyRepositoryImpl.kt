package com.example.disneyappob.data

import com.example.disneyappob.data.remote.RemoteDataSource

class DisneyRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : DisneyRepository {
}