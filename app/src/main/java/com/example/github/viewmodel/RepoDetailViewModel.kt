package com.example.github.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github.model.Repo

class RepoDetailViewModel(repo: Repo) : ViewModel() {

    private val _repo = MutableLiveData<Repo>()
    val repo: LiveData<Repo> get() = _repo

    init {
        _repo.value = repo
    }
}
