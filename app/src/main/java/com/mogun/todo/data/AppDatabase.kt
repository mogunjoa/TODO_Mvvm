package com.mogun.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mogun.todo.data.dao.ContentDao
import com.mogun.todo.model.ContentEntity

@Database(entities = [ContentEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun contentDao(): ContentDao
}