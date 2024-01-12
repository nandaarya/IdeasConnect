package com.example.ideasconnect.di

import android.content.Context
import com.example.ideasconnect.data.Repository
import com.example.ideasconnect.data.datastore.UserPreference
import com.example.ideasconnect.data.datastore.dataStore
import com.example.ideasconnect.data.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): Repository {
        val pref = UserPreference.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return Repository.getInstance(apiService, pref)
    }
}