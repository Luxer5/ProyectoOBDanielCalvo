package com.example.disneyappob.di

import com.example.disneyappob.domain.useCase.GetDetailUseCase
import com.example.disneyappob.domain.useCase.GetDisneyList1UseCase
import com.example.disneyappob.domain.useCase.GetDisneyList2UseCase
import com.example.disneyappob.domain.useCase.GetDisneyList3UseCase
import org.koin.dsl.module

val domainModule = module{

    single { GetDisneyList1UseCase(get()) }

    single { GetDisneyList2UseCase(get()) }

    single { GetDisneyList3UseCase(get()) }

    single { GetDetailUseCase(get()) }

}