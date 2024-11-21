package com.mogun.todo.data.di

import com.mogun.todo.repository.ContentRepository
import com.mogun.todo.repository.ContentRespositoryImpl
import com.mogun.todo.data.dao.ContentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideContentRepository(contentDao: ContentDao): ContentRepository = ContentRespositoryImpl(contentDao)
}