package com.zuh.central.datasource

import com.zuh.central.datasource.model.RecyclerList
import retrofit2.Response

interface GithubDatasource {

    suspend fun getGithubRepos(query: String): Response<RecyclerList>

}