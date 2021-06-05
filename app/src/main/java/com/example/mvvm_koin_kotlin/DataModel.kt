package com.example.mvvm_koin_kotlin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class DataModel(
    @PrimaryKey(autoGenerate = true)
    var userID: Int = 0,
    @ColumnInfo(name = "fullName")
    val userName: String,
    @ColumnInfo(name = "Designation")
    val userDesignation: String
)