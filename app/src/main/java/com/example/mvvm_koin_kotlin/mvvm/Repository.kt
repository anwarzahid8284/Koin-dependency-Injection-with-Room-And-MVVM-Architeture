package com.example.mvvm_koin_kotlin.mvvm


import android.accounts.NetworkErrorException
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvm_koin_kotlin.network.APIService
import com.example.mvvm_koin_kotlin.room.DataModel
import com.example.mvvm_koin_kotlin.network.NetworkData
import com.example.mvvm_koin_kotlin.room.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Repository(
    private val userDao: UserDao,
    private val apiService: APIService,
    context: Context
) : APIService {
    lateinit var list:Response<List<NetworkData>>
    lateinit var listdata:ArrayList<NetworkData>
    override suspend fun getAllCountries(): Response<List<NetworkData>> {
        val responseGet = apiService.getAllCountries()
        try {
            if (responseGet.isSuccessful) {
                responseGet.body()?.let {
                    withContext(Dispatchers.IO) {
                        listdata.addAll(it)
                    }
                }
            }
        } catch (e: NetworkErrorException) {

        }
        return list
    }

    fun getAllUser(): LiveData<List<DataModel>> {
        return userDao.getAllUser()
    }

    fun addUser(userAdd: DataModel) {
        userDao.addUser(userAdd)
    }

    fun updateUser(id: Int, updateName: String, updateDesignation: String) {
        userDao.updateUser(id, updateName, updateDesignation)
    }

    fun deleteUser(userDelete: DataModel) {
        userDao.deleteUser(userDelete)

    }
}