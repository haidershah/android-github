package com.example.github.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos_table")
data class DatabaseRepo(

    @PrimaryKey
    val id: String,

    val name: String,

    val description: String?
)
