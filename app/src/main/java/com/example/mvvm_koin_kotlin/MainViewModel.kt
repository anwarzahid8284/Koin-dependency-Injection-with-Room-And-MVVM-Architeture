package com.example.mvvm_koin_kotlin

import android.service.autofill.UserData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(val userDao: UserDao) : ViewModel() {
    fun getAllUser(): LiveData<List<DataModel>> = userDao.getAllUser()

    fun addUser(userAdd: DataModel) {
            userDao.addUser(userAdd)
    }
    fun updateUser(id:Int,updateName:String,updateDesignation:String) {
            userDao.updateUser(id,updateName,updateDesignation)
    }

    fun deleteUser(userDelete: DataModel) {
            userDao.deleteUser(userDelete)

    }
}