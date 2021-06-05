package com.example.mvvm_koin_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("select * from userTable")
    fun getAllUser(): LiveData<List<DataModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(addUser: DataModel)

    @Query("UPDATE userTable SET fullName =:updateName, Designation=:updateDesignation where userID=:id")
    fun updateUser(id:Int,updateName:String,updateDesignation:String)

    @Delete
    fun deleteUser(deleteUser: DataModel)
}