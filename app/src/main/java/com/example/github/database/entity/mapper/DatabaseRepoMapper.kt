package com.example.github.database.entity.mapper

import com.example.github.database.entity.DatabaseRepo
import com.example.github.domain.model.Repo

fun DatabaseRepo.asDomainModel(): Repo {
    return Repo(id, name, description, language, stars.toString(), forks.toString())
}
