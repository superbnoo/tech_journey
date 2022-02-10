package com.zuh.central.datasource

import com.zuh.central.datasource.model.RecyclerList
import retrofit2.Response

interface GithubDatasource {

    suspend fun getGithubRepos(number: Int): Response<ArrayList<RecyclerList>>

}