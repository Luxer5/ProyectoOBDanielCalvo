package com.example.disneyappob.domain.useCase

import com.example.disneyappob.data.DisneyRepository
import com.example.disneyappob.domain.model.DisneyModel

class GetDetailUseCase(
    private val disneyRepository: DisneyRepository
) {

    suspend fun invoke(id: Int): DisneyModel = disneyRepository.getDisneyCharacter(id)
}