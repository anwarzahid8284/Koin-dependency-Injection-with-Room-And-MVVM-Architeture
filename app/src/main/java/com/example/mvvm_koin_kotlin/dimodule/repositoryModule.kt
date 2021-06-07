package com.example.mvvm_koin_kotlin.dimodule

import com.example.mvvm_koin_kotlin.mvvm.Repository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val  repositoryModule = module{
    single { Repository(get(),get(),androidContext()) }
}