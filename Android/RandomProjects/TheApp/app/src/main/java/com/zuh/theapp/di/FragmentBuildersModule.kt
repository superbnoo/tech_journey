package com.zuh.theapp.di

import com.zuh.theapp.ui.GithubFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeFirstFragment(): GithubFragment
}