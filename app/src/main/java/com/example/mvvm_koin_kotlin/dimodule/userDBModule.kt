package com.example.mvvm_koin_kotlin.dimodule

import android.app.Application
import androidx.room.Room
import com.example.mvvm_koin_kotlin.room.UserDB
import com.example.mvvm_koin_kotlin.room.UserDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val userDB = module {
    fun provideDataBase(application: Application): UserDB {
        return Room.databaseBuilder(application, UserDB::class.java, "USERDB")
            .build()
    }

    fun provideDao(dataBase: UserDB): UserDao {
        return dataBase.userDao
    }
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }

}
