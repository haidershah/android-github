package com.example.github.network

import com.example.github.network.model.Repo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.github.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface GitHubApiService {

    @GET("users/{user}/repos")
    suspend fun getRepos(@Path("user") user: String): List<Repo>
}

object GitHubApi {
    val RETROFIT_SERVICE: GitHubApiService by lazy {
        retrofit.create(GitHubApiService::class.java)
    }
}
