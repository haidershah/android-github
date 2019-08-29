package com.example.github.network

import com.example.github.model.Repo
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.github.com/"

private val retrofit = Retrofit.Builder()
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface GitHubApiService {

    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Flowable<List<Repo>>
}

object GitHubApi {
    val RETROFIT_SERVICE: GitHubApiService by lazy {
        retrofit.create(GitHubApiService::class.java)
    }
}
