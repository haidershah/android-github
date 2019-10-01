package com.example.github.network

import com.example.github.network.model.NetworkRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.github.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface GitHubApiService {

    @GET("users/{user}/repos")
    suspend fun getRepos(
        @Path("user") user: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<NetworkRepo>
}

object GitHubApi {
    val RETROFIT_SERVICE: GitHubApiService by lazy {
        retrofit.create(GitHubApiService::class.java)
    }
}
