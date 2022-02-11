package com.zuh.central.datasource

import com.zuh.central.datasource.api.GithubServiceInterface
import com.zuh.central.datasource.model.RecyclerList
import javax.inject.Inject
import retrofit2.Response

class GithubDatasourceImpl @Inject constructor(private val githubService: GithubServiceInterface) :
    GithubDatasource {
    override suspend fun getGithubRepos(query: String): Response<RecyclerList> =
        githubService.getGithubRepos(query)
}