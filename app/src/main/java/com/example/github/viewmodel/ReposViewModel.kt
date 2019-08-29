package com.example.github.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github.model.Repo
import com.example.github.network.GitHubApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ReposViewModel : ViewModel() {

    private lateinit var disposable: Disposable

    private val _response = MutableLiveData<List<Repo>>()
    val response: LiveData<List<Repo>> get() = _response

    init {
        getRepos("haidershah")
    }

    private fun getRepos(user: String) {
        disposable = GitHubApi.RETROFIT_SERVICE.getRepos(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> showResult(result) },
                { error -> showError(error) }
            )
    }

    private fun showResult(repos: List<Repo>) {
        _response.value = repos
    }

    private fun showError(t: Throwable) {

    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}
