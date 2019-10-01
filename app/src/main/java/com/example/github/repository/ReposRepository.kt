package com.example.github.repository

import androidx.paging.DataSource
import com.example.github.database.RepoDatabase
import com.example.github.database.entity.mapper.asDomainModel
import com.example.github.domain.model.Repo
import com.example.github.network.model.mapper.asDatabaseModels
import com.example.github.network.GitHubApi

class ReposRepository(private val database: RepoDatabase) {

    val repos: DataSource.Factory<Int, Repo> = database.dao.getRepos().map {
        it.asDomainModel()
    }

    suspend fun getRepos(user: String, page: Int, perPage: Int) {
        val repos = GitHubApi.RETROFIT_SERVICE.getRepos(user, page, perPage)

        // when fresh data is fetched, delete old data
        if (page == 1) {
            database.dao.deleteAll()
        }
        database.dao.insertAll(repos.asDatabaseModels())
    }
}
