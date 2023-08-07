package com.example.disneyappob.domain.useCase

import com.example.disneyappob.data.DisneyRepository
import com.example.disneyappob.domain.model.DisneyModel

class DeleteFavoriteUseCase(
    private val disneyRepository: DisneyRepository
) {

    suspend fun invoke(character: DisneyModel) = disneyRepository.deleteFav(character)
}