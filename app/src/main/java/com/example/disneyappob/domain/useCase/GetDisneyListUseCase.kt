package com.example.disneyappob.domain.useCase

import com.example.disneyappob.data.DisneyRepository
import com.example.disneyappob.domain.model.DisneyListModel

class GetDisneyListUseCase(
    private val disneyRepository: DisneyRepository
) {

    suspend fun invoke() : List<DisneyListModel> = disneyRepository.getDisneyList()
}