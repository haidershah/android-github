package com.example.github.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github.database.RepoDatabase
import com.example.github.model.Repo
import com.example.github.network.GitHubApi
import com.example.github.repository.ReposRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ReposViewModel(context: Context) : ViewModel() {

    private val _response = MutableLiveData<List<Repo>>()
    val response: LiveData<List<Repo>> get() = _response

    private val database = RepoDatabase.getInstance(context)
    private val repository = ReposRepository(database)

    init {
        CoroutineScope(Dispatchers.IO).launch {
            repository.getRepos("haidershah")
        }
    }

    val repos = repository.repos

    // todo remove
    private fun getRepos(user: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repos = GitHubApi.RETROFIT_SERVICE.getRepos("haidershah")

                withContext(Dispatchers.Main) {
                    _response.value = repos
                }
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}
