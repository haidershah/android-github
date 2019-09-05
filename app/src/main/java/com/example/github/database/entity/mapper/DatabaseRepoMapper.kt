package com.example.github.database.entity.mapper

import com.example.github.database.entity.DatabaseRepo
import com.example.github.network.model.Repo

fun List<DatabaseRepo>.asDomainModel(): List<Repo> {
    return map {
        it.asDomainModel()
    }
}

fun DatabaseRepo.asDomainModel(): Repo {
    return Repo(id, name, description)
}
