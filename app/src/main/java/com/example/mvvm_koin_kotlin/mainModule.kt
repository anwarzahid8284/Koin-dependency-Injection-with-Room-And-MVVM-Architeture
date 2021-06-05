package com.example.mvvm_koin_kotlin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val  mainViewModel= module{
    viewModel {
        MainViewModel(get())
    }
}