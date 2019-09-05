package com.example.github.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repo(

    val id: String,
    val name: String,
    val description: String?
) : Parcelable
