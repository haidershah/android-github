package com.example.github.view.listener

import com.example.github.domain.model.Repo

interface ReposListener {

    fun onRepoClicked(repo: Repo)
}
