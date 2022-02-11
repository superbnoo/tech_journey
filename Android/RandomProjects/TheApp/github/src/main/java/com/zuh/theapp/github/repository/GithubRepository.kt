package com.zuh.theapp.github.repository

import com.zuh.central.datasource.GithubDatasource
import com.zuh.central.datasource.ResourceState
import com.zuh.central.datasource.model.RecyclerList
import com.zuh.central.utils.NetworkBoundSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class GithubRepository(
    private val githubDatasource: GithubDatasource
) {
    fun getGithubRepos(query: String): Flow<ResourceState<RecyclerList>> {
        return object : NetworkBoundSource<RecyclerList, RecyclerList>() {

            override suspend fun fetchFromRemote(): Response<RecyclerList> {

                val response = githubDatasource.getGithubRepos(query)
                print(response)
                return response
            }

            override suspend fun postProcess(originalData: RecyclerList): RecyclerList {
                return originalData
            }

        }.asFlow().flowOn(Dispatchers.IO)
    }
}