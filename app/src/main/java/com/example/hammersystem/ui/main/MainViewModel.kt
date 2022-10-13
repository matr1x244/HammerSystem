package com.example.hammersystem.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammersystem.domain.model.RepositoryFood
import com.example.hammersystem.domain.model.data.DataFood
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: RepositoryFood) : ViewModel() {

    private val _repos = MutableLiveData<List<DataFood>>()
    val repos: LiveData<List<DataFood>> = _repos


    fun onShowList() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("@@@", "No success $throwable")
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = repository.observerListFood()
            withContext(Dispatchers.Main) {
                _repos.postValue(result)
            }
        }
    }
}