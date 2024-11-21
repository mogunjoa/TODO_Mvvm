package com.mogun.todo.repository

import com.mogun.todo.model.ContentEntity

interface ContentRepository {

    suspend fun insert(content: ContentEntity)

}