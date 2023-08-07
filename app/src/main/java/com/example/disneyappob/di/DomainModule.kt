package com.example.disneyappob.di

import com.example.disneyappob.domain.useCase.GetDetailUseCase
import com.example.disneyappob.domain.useCase.GetDisney1ListUseCase
import com.example.disneyappob.domain.useCase.GetDisneyList2UseCase
import org.koin.dsl.module

val domainModule = module{

    single { GetDisney1ListUseCase(get()) }

    single { GetDisneyList2UseCase(get()) }

    single { GetDetailUseCase(get()) }

}