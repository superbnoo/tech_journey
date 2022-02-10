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

}