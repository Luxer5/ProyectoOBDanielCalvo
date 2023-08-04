package com.example.disneyappob.di

import com.example.disneyappob.domain.useCase.GetDetailUseCase
import com.example.disneyappob.domain.useCase.GetDisneyListUseCase
import org.koin.dsl.module

val domainModule = module{

    single { GetDisneyListUseCase(get()) }

    single { GetDetailUseCase(get()) }

}