package com.example.mvvm_koin_kotlin

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val userDB = module {
    fun provideDataBase(application: Application): UserDB {
        return Room.databaseBuilder(application, UserDB::class.java, "USERDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: UserDB): UserDao {
        return dataBase.userDao
    }
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }

}