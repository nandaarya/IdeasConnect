package com.example.ideasconnect.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ideasconnect.data.Repository
import com.example.ideasconnect.data.response.IdeaListItem
import kotlinx.coroutines.launch
import com.example.ideasconnect.data.Result

class MainViewModel(private val repository: Repository) : ViewModel() {

    private fun getToken(): String {
        var token = ""
        viewModelScope.launch {
            repository.getSession().collect{ user ->
                token = user.token
            }
        }
        return token
    }

    private var _ideaList = MediatorLiveData<Result<List<IdeaListItem>>>()
    var ideaList: LiveData<Result<List<IdeaListItem>>> = _ideaList

    fun getIdeaList() {
        val liveData = repository.getIdeaList(getToken())
        _ideaList.addSource(liveData) { result ->
            _ideaList.value = result
            Log.d("list viewmodel", result.toString())
        }
    }



}