package com.example.github.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.github.database.RepoDatabase
import com.example.github.repository.ReposRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ReposViewModel(context: Context) : ViewModel() {

    private val database = RepoDatabase.getInstance(context)
    private val repository = ReposRepository(database)

    val repos = repository.repos

    private val apiJob = Job()

    init {
        CoroutineScope(Dispatchers.IO + apiJob).launch {
            repository.getRepos("haidershah")
        }
    }

    override fun onCleared() {
        super.onCleared()
        apiJob.cancel()
    }
}
