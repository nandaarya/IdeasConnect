package com.example.ideasconnect.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.ideasconnect.data.datastore.UserPreference
import com.example.ideasconnect.data.response.DataDummy
import com.example.ideasconnect.data.response.IdeaListItem
import com.example.ideasconnect.data.response.LoginResponse
import com.example.ideasconnect.data.response.RegisterResponse
import com.example.ideasconnect.data.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class Repository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference,
) {

    private suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    fun register(
        name: String,
        email: String,
        password: String
    ): LiveData<Result<RegisterResponse>> =
        liveData(Dispatchers.IO) {
            emit(Result.Loading)
            try {
                val response = apiService.register(name, email, password)
                emit(Result.Success(response))
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
            }
        }

    fun login(email: String, password: String): LiveData<Result<LoginResponse>> =
        liveData(Dispatchers.IO) {
            emit(Result.Loading)
            try {
                val response = apiService.login(email, password)
                val token = response.loginResult.token
                val name = response.loginResult.name
                val userId = response.loginResult.userId
                saveSession(UserModel(userId, name, email, token))
                emit(Result.Success(response))
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
            }
        }

    fun getIdeaList(token: String): LiveData<Result<List<IdeaListItem>>> =
        liveData(Dispatchers.IO) {
            emit(Result.Loading)
            try {
//                Log.d("list repository", "Mulai get data list")
//                val response = apiService.getIdeaList( "Bearer $token")
//                Log.d("list repository", response.message)
                val ideaList = DataDummy.ideaListDummy
                emit(Result.Success(ideaList))
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
            }
        }

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference,
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(apiService, userPreference)
            }.also { instance = it }
    }
}