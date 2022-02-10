package com.zuh.theapp.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DatasourceModule {
    private val baseGithubURL = "https://api.github.com/search/"

    @Singleton
    @Provides
    fun getGithubServiceInterface(retrofit: Retrofit):GithubServiceInterface {
        return retrofit.create(GithubServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun getGithubRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseGithubURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}