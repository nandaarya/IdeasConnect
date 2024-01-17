package com.example.ideasconnect.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.ideasconnect.data.Repository
import com.example.ideasconnect.data.UserModel
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: Repository): ViewModel() {

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}