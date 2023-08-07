package com.example.disneyappob.di

import com.example.disneyappob.domain.useCase.GetDetailUseCase
import com.example.disneyappob.domain.useCase.GetDisney1ListUseCase
import org.koin.dsl.module

val domainModule = module{

    single { GetDisney1ListUseCase(get()) }

    single { GetDetailUseCase(get()) }

}