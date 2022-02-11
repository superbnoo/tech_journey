package com.zuh.theapp.github.di

import com.zuh.central.datasource.GithubDatasource
import com.zuh.theapp.di.ViewModelModule
import com.zuh.theapp.github.repository.GithubRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    ViewModelModule::class
])
class GithubModule {
    @Singleton
    @Provides
    fun getGithubRepository(
        githubDatasource: GithubDatasource
    ): GithubRepository = GithubRepository(githubDatasource)
}