package com.example.mvvm_koin_kotlin.dimodule

import com.example.mvvm_koin_kotlin.mvvm.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val  mainViewModel= module{
    viewModel {
        MainViewModel(get())
    }
}