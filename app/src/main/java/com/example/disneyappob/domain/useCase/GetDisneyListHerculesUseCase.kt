package com.example.disneyappob.domain.useCase

import com.example.disneyappob.data.DisneyRepository
import com.example.disneyappob.domain.model.DisneyListModel

class GetDisneyListHerculesUseCase(
    private val disneyRepository: DisneyRepository
) {

    suspend fun invoke() : List<DisneyListModel> = disneyRepository.getDisneyListHercules()
}