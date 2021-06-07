package com.example.mvvm_koin_kotlin

import android.app.Application
import com.example.mvvm_koin_kotlin.dimodule.apiModule
import com.example.mvvm_koin_kotlin.dimodule.mainViewModel
import com.example.mvvm_koin_kotlin.dimodule.repositoryModule
import com.example.mvvm_koin_kotlin.dimodule.userDB
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@KoinApplication)
            modules(

                userDB,
                mainViewModel,
                apiModule,
                repositoryModule,


            )
        }
    }
}