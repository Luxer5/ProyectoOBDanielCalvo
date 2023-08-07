package com.example.disneyappob.domain.useCase

import com.example.disneyappob.data.DisneyRepository
import com.example.disneyappob.domain.model.DisneyModel

class InsertFavoriteUseCase (
    private val disneyRepository: DisneyRepository
        ){

    suspend fun invoke(character: DisneyModel) = disneyRepository.insertFav(character)
}