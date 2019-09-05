package com.example.github.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.github.database.RepoDatabase
import com.example.github.database.entity.mapper.asDomainModel
import com.example.github.domain.model.Repo
import com.example.github.network.model.mapper.asDatabaseModel
import com.example.github.network.GitHubApi

class ReposRepository(private val database: RepoDatabase) {

    val repos: LiveData<List<Repo>> = Transformations.map(database.dao.getRepos()) {
        it.asDomainModel()
    }

    suspend fun getRepos(user: String) {
        val repos = GitHubApi.RETROFIT_SERVICE.getRepos(user)
        database.dao.insertAll(repos.asDatabaseModel())
    }
}
