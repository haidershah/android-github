package com.example.github.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.github.database.RepoDatabase
import com.example.github.domain.model.Repo
import com.example.github.repository.ReposRepository
import com.example.github.view.callback.RepoBoundaryCallback
import kotlinx.coroutines.*

class ReposViewModel(context: Context) : ViewModel() {

    private val database = RepoDatabase.getInstance(context)
    private val repository = ReposRepository(database)

    // keep the last requested page. When the request is successful, increment the page number.
    private var page = 1

    var repos: LiveData<PagedList<Repo>>

    companion object {
        const val PAGE_SIZE = 10
    }

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build()

        val factory: DataSource.Factory<Int, Repo> = repository.repos
        val boundaryCallback = RepoBoundaryCallback {
            getRepos(page)
        }

        repos = LivePagedListBuilder(factory, config)
            .setBoundaryCallback(boundaryCallback)
            .build()

        getRepos(page)
    }

    private fun getRepos(lastRequestedPage: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getRepos("fabpot", lastRequestedPage, PAGE_SIZE)
            }
            page++
        }
    }
}
