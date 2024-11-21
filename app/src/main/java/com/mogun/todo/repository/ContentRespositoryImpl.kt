package com.mogun.todo.repository

import com.mogun.todo.data.dao.ContentDao
import com.mogun.todo.model.ContentEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContentRespositoryImpl @Inject constructor(private val contentDao: ContentDao): ContentRepository {
    override fun loadList(): Flow<List<ContentEntity>> = contentDao.selectAll()

    override suspend fun insert(content: ContentEntity) {
        contentDao.insert(content)
    }
}