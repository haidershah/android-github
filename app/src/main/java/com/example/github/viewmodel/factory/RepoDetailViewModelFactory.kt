package com.example.github.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.github.model.Repo
import com.example.github.viewmodel.RepoDetailViewModel
import java.lang.IllegalArgumentException

class RepoDetailViewModelFactory(
    private val repo: Repo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepoDetailViewModel::class.java)) {
            return RepoDetailViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
