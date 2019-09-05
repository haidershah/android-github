package com.example.github.network.model.mapper

import android.util.Log
import com.example.github.database.entity.DatabaseRepo
import com.example.github.network.model.NetworkRepo

fun List<NetworkRepo>.asDatabaseModel(): List<DatabaseRepo> {
    return map {
        it.asDatabaseModel()
    }
}

fun NetworkRepo.asDatabaseModel(): DatabaseRepo {
    Log.e("yooooo", "id: $id")
    Log.e("yooooo", "name: $name")
    Log.e("yooooo", "description: $description")
    return DatabaseRepo(id, name, description)
}