package com.mogun.todo.data.di

import com.mogun.todo.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun provideContentDao(appDatabase: AppDatabase) = appDatabase.contentDao()
}