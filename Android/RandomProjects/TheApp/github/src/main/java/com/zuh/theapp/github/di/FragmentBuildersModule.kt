package com.zuh.theapp.github.di

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeGithubFragment(): com.zuh.theapp.github.ui.GithubFragment
}