package com.mogun.todo.repository

import com.mogun.todo.data.dao.ContentDao
import com.mogun.todo.model.ContentEntity
import javax.inject.Inject

class ContentRespositoryImpl @Inject constructor(private val contentDao: ContentDao): ContentRepository {
    override suspend fun insert(content: ContentEntity) {
        contentDao.insert(content)
    }
}