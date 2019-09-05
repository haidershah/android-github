package com.example.github.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.github.database.RepoDatabase
import com.example.github.repository.ReposRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReposViewModel(context: Context) : ViewModel() {

    private val database = RepoDatabase.getInstance(context)
    private val repository = ReposRepository(database)

    init {
        CoroutineScope(Dispatchers.IO).launch {
            repository.getRepos("haidershah")
        }
    }

    val repos = repository.repos
}
