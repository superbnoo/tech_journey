package com.zuh.theapp.di

import com.zuh.theapp.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubServiceInterface {

    @GET("repositories")
    fun getDataFromAPI(@Query("q")query: String): Call<RecyclerList>?
}