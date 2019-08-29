package com.example.github.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.github.model.Repo
import com.example.github.network.GitHubApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ReposViewModel : ViewModel() {

    private lateinit var disposable: Disposable

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
        Log.e("yooooo", "properties: $repos")
    }

    private fun showError(t: Throwable) {

    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}
