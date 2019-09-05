package com.example.github.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github.network.model.NetworkRepo

class RepoDetailViewModel(repo: NetworkRepo) : ViewModel() {

    private val _repo = MutableLiveData<NetworkRepo>()
    val repo: LiveData<NetworkRepo> get() = _repo

    init {
        _repo.value = repo
    }
}
