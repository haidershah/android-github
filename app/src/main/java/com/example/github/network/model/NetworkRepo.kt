package com.example.github.network.model

import com.google.gson.annotations.SerializedName

data class NetworkRepo(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String?,

    @SerializedName("language")
    val language: String?
)
