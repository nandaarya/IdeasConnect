package com.example.ideasconnect.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.ideasconnect.data.Repository
import com.example.ideasconnect.data.response.RegisterResponse
import com.example.ideasconnect.data.Result

class SignupViewModel(private val repository: Repository): ViewModel() {

    private val _registerResponse = MediatorLiveData<Result<RegisterResponse>>()
    val registerResponse: LiveData<Result<RegisterResponse>> = _registerResponse

    fun register(name: String, email: String, password: String) {
        val liveData = repository.register(name, email, password)
        _registerResponse.addSource(liveData) { result ->
            _registerResponse.value = result
        }
    }
}