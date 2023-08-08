package com.example.disneyappob.domain.useCase

import com.example.disneyappob.data.DisneyRepository

class CheckFavoriteUseCase(
    private val disneyRepository: DisneyRepository
) {
    suspend fun invoke(id: Int) = disneyRepository.checkFav(id)
}