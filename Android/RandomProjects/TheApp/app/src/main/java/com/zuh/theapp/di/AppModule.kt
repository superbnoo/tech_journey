package com.zuh.theapp.di

import com.zuh.central.datasource.GithubDatasource
import com.zuh.theapp.repository.GithubRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    ViewModelModule::class
])
class AppModule {
    @Singleton
    @Provides
    fun getGithubRepository(
        githubDatasource: GithubDatasource
    ): GithubRepository = GithubRepository(githubDatasource)
}