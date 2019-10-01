package com.example.github.network.model.mapper

import com.example.github.database.entity.DatabaseRepo
import com.example.github.network.model.NetworkRepo

fun List<NetworkRepo>.asDatabaseModels(): List<DatabaseRepo> {
    return map {
        it.asDatabaseModels()
    }
}

fun NetworkRepo.asDatabaseModels(): DatabaseRepo {
    return DatabaseRepo(id, name, description, language, stars, forks)
}
