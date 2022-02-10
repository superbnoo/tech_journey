package com.zuh.theapp.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [
    ViewModelModule::class
])
class AppModule {
    val baseURL = "https://api.github.com/search/"//repositories?q=newyork

    @Singleton
    @Provides
    fun getGithubServiceInterface(retrofit: Retrofit):GithubServiceInterface {
        return retrofit.create(GithubServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetroFitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}