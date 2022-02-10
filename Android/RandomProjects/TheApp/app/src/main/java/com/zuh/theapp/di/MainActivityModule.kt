package com.zuh.theapp.di

import com.zuh.theapp.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}