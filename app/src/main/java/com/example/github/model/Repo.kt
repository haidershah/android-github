package com.example.github.model

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String
)
