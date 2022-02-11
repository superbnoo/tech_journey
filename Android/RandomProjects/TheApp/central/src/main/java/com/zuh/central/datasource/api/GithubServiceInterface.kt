package com.zuh.central.datasource.api

import com.zuh.central.datasource.model.RecyclerList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubServiceInterface {

    @GET("repositories")
    fun getDataFromAPI(@Query("q")query: String): Call<RecyclerList>?

    @GET("repositories")
    suspend fun getGithubRepos(@Query("q")query: String): Response<RecyclerList>
}