package com.example.mvvm_koin_kotlin

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(DataModel::class),version = 1,exportSchema = false)
abstract class UserDB:RoomDatabase(){
    abstract val userDao:UserDao
}