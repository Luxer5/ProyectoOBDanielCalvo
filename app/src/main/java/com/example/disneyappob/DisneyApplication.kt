package com.example.disneyappob

import android.app.Application
import com.example.disneyappob.di.dataModule
import com.example.disneyappob.di.domainModule
import com.example.disneyappob.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class DisneyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@DisneyApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}