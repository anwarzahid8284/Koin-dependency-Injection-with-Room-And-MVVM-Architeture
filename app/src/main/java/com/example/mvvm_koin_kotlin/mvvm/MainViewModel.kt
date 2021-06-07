package com.example.mvvm_koin_kotlin.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_koin_kotlin.network.NetworkData
import com.example.mvvm_koin_kotlin.room.DataModel

class MainViewModel(private val repository: Repository) : ViewModel() {
    fun getAllUser(): LiveData<List<DataModel>> = repository.getAllUser()
    fun getAllPost():List<NetworkData> =repository.listdata

    fun addUser(userAdd: DataModel) {
        repository.addUser(userAdd)
    }

    fun updateUser(id: Int, updateName: String, updateDesignation: String) {
        repository.updateUser(id, updateName, updateDesignation)
    }

    fun deleteUser(userDelete: DataModel) {
        repository.deleteUser(userDelete)

    }
}