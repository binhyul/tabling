package com.example.tabling.local.source

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Singleton
    @Binds
    abstract fun bindAppLocalDataSource(
        appLocalDataSourceImpl: AppLocalDataSourceImpl
    ): AppLocalDataSource

}