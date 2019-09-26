package com.example.github.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github.database.RepoDatabase
import com.example.github.repository.ReposRepository
import kotlinx.coroutines.*

class ReposViewModel(context: Context) : ViewModel() {

    private val database = RepoDatabase.getInstance(context)
    private val repository = ReposRepository(database)

    val repos = repository.repos

    init {
        viewModelScope.launch {
            getRepos()
        }
    }

    private suspend fun getRepos() {
        withContext(Dispatchers.IO) {
            repository.getRepos("haidershah")
        }
    }
}
