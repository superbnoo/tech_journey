package com.zuh.theapp.di

import com.zuh.central.datasource.GithubDatasource
import com.zuh.central.datasource.GithubDatasourceImpl
import com.zuh.central.datasource.api.GithubServiceInterface
import com.zuh.theapp.repository.GithubRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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