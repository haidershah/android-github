package com.example.github.database.entity.mapper

import com.example.github.database.entity.DatabaseRepo
import com.example.github.network.model.NetworkRepo

fun List<DatabaseRepo>.asDomainModel(): List<NetworkRepo> {
    return map {
        it.asDomainModel()
    }
}

fun DatabaseRepo.asDomainModel(): NetworkRepo {
    return NetworkRepo(id, name, description)
}
