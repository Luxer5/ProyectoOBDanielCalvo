package com.example.disneyappob.di

import android.content.Context
import androidx.room.Room
import com.example.disneyappob.data.DisneyRepository
import com.example.disneyappob.data.DisneyRepositoryImpl
import com.example.disneyappob.data.local.DisneyDao
import com.example.disneyappob.data.local.DisneyDatabase
import com.example.disneyappob.data.local.LocalDataSource
import com.example.disneyappob.data.local.LocalDataSourceImpl
import com.example.disneyappob.data.remote.DisneyApi
import com.example.disneyappob.data.remote.RemoteDataSource
import com.example.disneyappob.data.remote.RemoteDataSourceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    single{
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT ).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit>{
        Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi>{
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<DisneyRepository> { DisneyRepositoryImpl(get(), get()) }

    single<RemoteDataSource>{ RemoteDataSourceImpl(get()) }

    single<DisneyApi>{
        getDisneyApi(get())
    }
    single <LocalDataSource> { LocalDataSourceImpl(get())}

    single { getDatabase(get()) }
    single { providesDisneyDao(get()) }
}

private fun getDisneyApi(retrofit: Retrofit) = retrofit.create(DisneyApi::class.java)

private fun getDatabase(context: Context): DisneyDatabase =
    Room.databaseBuilder(
        context = context,
        DisneyDatabase::class.java,
        "disneychaarc-db"
    ).build()

private fun providesDisneyDao(db : DisneyDatabase): DisneyDao = db.disneyDao()