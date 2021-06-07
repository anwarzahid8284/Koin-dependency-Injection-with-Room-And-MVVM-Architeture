package com.example.mvvm_koin_kotlin.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataModel::class], version = 1, exportSchema = false)
abstract class UserDB : RoomDatabase() {
    abstract val userDao: UserDao
}