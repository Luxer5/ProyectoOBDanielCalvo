package com.example.disneyappob.di

import com.example.disneyappob.domain.useCase.DeleteFavoriteUseCase
import com.example.disneyappob.domain.useCase.GetDetailUseCase
import com.example.disneyappob.domain.useCase.GetDisneyListTreasureUseCase
import com.example.disneyappob.domain.useCase.GetDisneyListHeroUseCase
import com.example.disneyappob.domain.useCase.GetDisneyListHerculesUseCase
import com.example.disneyappob.domain.useCase.GetFavoriteListUseCase
import com.example.disneyappob.domain.useCase.InsertFavoriteUseCase
import org.koin.dsl.module

val domainModule = module{

    single { GetDisneyListTreasureUseCase(get()) }

    single { GetDisneyListHeroUseCase(get()) }

    single { GetDisneyListHerculesUseCase(get()) }

    single { GetDetailUseCase(get()) }

    single { InsertFavoriteUseCase(get()) }

    single { DeleteFavoriteUseCase(get()) }

    single { GetFavoriteListUseCase(get()) }

}