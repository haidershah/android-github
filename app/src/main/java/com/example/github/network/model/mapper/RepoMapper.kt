package com.example.github.network.model.mapper

import com.example.github.database.entity.DatabaseRepo
import com.example.github.network.model.NetworkRepo

fun List<NetworkRepo>.asDatabaseModel(): List<DatabaseRepo> {
    return map {
        it.asDatabaseModel()
    }
}

fun NetworkRepo.asDatabaseModel(): DatabaseRepo {
    return DatabaseRepo(id, name, description)
}
