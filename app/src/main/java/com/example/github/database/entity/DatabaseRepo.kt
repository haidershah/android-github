package com.example.github.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repos_table")
data class DatabaseRepo(

    @PrimaryKey
    val id: String,

    val name: String,

    val description: String?,

    val language: String?,

    val stars: Int,

    val forks: Int
)
