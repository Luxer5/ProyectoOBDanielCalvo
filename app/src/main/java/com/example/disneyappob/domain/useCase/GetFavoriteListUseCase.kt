package com.example.disneyappob.domain.useCase

import com.example.disneyappob.data.DisneyRepository
import com.example.disneyappob.domain.model.DisneyListModel

class GetFavoriteListUseCase(
    private var disneyRepository: DisneyRepository
) {
    suspend fun invoke() : List<DisneyListModel> = disneyRepository.getAll()

}